package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Vmax extends Card implements CardPrice {

	@Override
	public double cost(Ride ride) {
		if (ride.duration()/60.0 <= 1.0)
				return 0;
		else
			return (ride.duration()/60.0 - 1.0); //1€ l'heure supplémentaire peu importe le type de bike
	}

}
