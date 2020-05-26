package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public interface Observer {
	
	public void updateBalance(Bike bike);
	// this will be used to update the balance of the different cards following a ride
	// will take in argument an object ride
	
	public void updateStation(Bike bike, String movement);
	// when a bike is rented/dropped, we update the status of the parking slot that contains
	// the bike from which we received the notification
}
