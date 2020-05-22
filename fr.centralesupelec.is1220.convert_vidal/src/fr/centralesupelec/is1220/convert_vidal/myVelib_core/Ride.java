package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Ride {
	Station departure;
	Station arrival;
	Bike bike;
	User user;
	
	public Ride(Station departure, Bike bike, User user) {
		super();
		this.departure = departure;
		this.arrival = null; //Le arrival sera set lors du dépot du vélo
		this.bike = bike;
		this.user = user;
	}
	
	public double duration() {
		return (departure.distance(arrival)/15.0)*60.0;//On estime la vitesse moyenne en ville à 15km/h
	}
	

}
