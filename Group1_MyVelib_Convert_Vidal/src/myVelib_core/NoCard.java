package myVelib_core;

public class NoCard extends Card {

	@Override
	public double cost(Ride ride) {
		if (ride.getRideType() == "mechanical") {
			return ride.duration()/60.0; // Une heure de vélo coute ici 1€
		}
		else { //Dans ce cas le type de bike sera forcément électrique
			return ride.duration()/30.0;// Une heure de vélo électrique coute ici 2€
		}
	}
	
	

}
