package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Ride {
	private Station departure;
	private Station arrival;
	private Bike bike;
	private User user;
	
	public Ride(Station departure, Bike bike, User user) {
		super();
		this.departure = departure;
		this.arrival = null; //Le arrival sera set lors du dépot du vélo
		this.bike = bike;
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


	public Bike getBike() {
		return bike;
	}


	public void setBike(Bike bike) {
		this.bike = bike;
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
