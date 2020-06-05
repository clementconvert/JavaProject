package test_package;

import static org.junit.Assert.*;

import org.junit.Test;

import myVelib_core.NoCard;
import myVelib_core.Ride;
import myVelib_core.Station;
import myVelib_core.User;

public class RideTest {

	@Test
	public void testDuration() {
		Station arrival = new Station(0,0,true, "standard", 10);  //on crée une station d'arrivée et une de départ
		Station departure = new Station(0,2,true, "standard", 10);
		NoCard noCard = new NoCard(); //on crée une carte car le constructeur de user nécessite une carte
		User user = new User("Pichard", 0, 0, 2, noCard); //on crée un user car le constructeur de ride nécessite un user
		Ride ride = new Ride(departure, "electrical", user); //on crée l'objet ride associé aux stations
		ride.setArrival(arrival);
		assertTrue(ride.duration()==2.0*60.0/15.0);  //la distance est de 2 km et on roule a 15kmh mais on veut le résultat en min
	}
	
	@Test
	public void testDuration2() {
		Station arrival = new Station(1,2,true, "standard", 10);  //on crée une station d'arrivée et une de départ
		Station departure = new Station(7,5,true, "standard", 10);
		NoCard noCard = new NoCard(); //on crée une carte car le constructeur de user nécessite une carte
		User user = new User("Pichard", 0, 0, 2, noCard); //on crée un user car le constructeur de ride nécessite un user
		Ride ride = new Ride(departure, "electrical", user); //on crée l'objet ride associé aux stations
		ride.setArrival(arrival);
		assertTrue(ride.duration()==Math.sqrt(45)*60.0/15.0);  //la distance est de racine de 45 km et on roule a 15kmh mais on veut le résultat en min
	
	}

}
