package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Vlibre extends Card implements CardPrice {

	@Override
	public double cost(Ride ride) {
		if (ride.getBike().getBikeType() == "mechanical") {
			if (ride.duration()/60.0 <= 1.0) {return 0;}
			else {return (ride.duration()/60.0-1.0);}//On ne facture que les heures après la première
		}
		else {
			if (ride.duration()/60.0 <= 1.0) {return ride.duration()/60.0;}
			else {return (1.0 + (ride.duration()/60.0 - 1.0)*2.0);}//On facture une heure à 1h et chaque heure supplémentaire à 2€
			
		}
	}

}
