package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Ride {
	private Station departure;
	private Station arrival;
	private String rideType; //on electrical or mechanical bike
	private User user;
	
	public Ride(Station departure, String bikeType, User user) {
		super();
		this.departure = departure;
		this.arrival = null; //Le arrival sera set lors du dépot du vélo
		this.rideType = bikeType;
		this.user = user;
	}
	
	
	public Station getDeparture() {
		return departure;
	}


	public void setDeparture(Station departure) {
		this.departure = departure;
	}


	public Station getArrival() {
		return arrival;
	}


	public void setArrival(Station arrival) {
		this.arrival = arrival;
	}


	public String getRideType() {
		return rideType;
	}


	public void setRideType(String rideType) {
		this.rideType = rideType;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public double duration() {
		return (departure.distance(arrival)/15.0)*60.0;//On estime la vitesse moyenne en ville à 15km/h
	}
	

}
