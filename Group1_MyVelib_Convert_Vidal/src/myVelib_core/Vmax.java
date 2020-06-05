package myVelib_core;

public class Vmax extends Card {

	@Override
	public double cost(Ride ride) {
		if (ride.getArrival().getType()=="plus") {ride.getUser().getCard().addTimeBalance(5);}; //on ajoute 5min de credit pour une carte Vmax
		
		if (ride.duration()/60.0 <= 1.0)
				return 0;
		else
			return (ride.duration()/60.0 - 1.0); //1€ l'heure supplémentaire peu importe le type de bike
	}

}
