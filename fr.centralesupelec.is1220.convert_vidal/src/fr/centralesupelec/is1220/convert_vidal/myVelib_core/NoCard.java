package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class NoCard extends Card implements CardPrice {

	@Override
	public double cost(Ride ride) {
		if (ride.getBike().getBikeType() == "mechanical") {
			return ride.duration()/60.0; // Une heure de vélo coute ici 1€
		}
		else { //Dans ce cas le type de bike sera forcément électrique
			return ride.duration()/30.0;// Une heure de vélo électrique coute ici 2€
		}
	}
	
	

}
