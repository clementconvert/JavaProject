package test_package;

import static org.junit.Assert.*;

import org.junit.Test;

import myVelib_core.MyVelib;
import myVelib_core.NoCard;
import myVelib_core.PlannedRide;
import myVelib_core.User;

public class PlannedRideTest {
	MyVelib system = new MyVelib(); //on crée un systeme myVelib composé de 10 stations, placées 
	                                //aléatoirement et remplies a 70% de vélos
	NoCard noCard = new NoCard(); //on crée une carte car le constructeur de user nécessite une carte
	User user = new User("Pichard", 0, 0, 2, noCard);
	//dans un test a la main nous avons créé l'objet system pour voir a la main quelles seraient les stations conseillées par planRide
	//nous nous attendons a avoir la station 2 au départ et la station 6 a l'arrivée
	//avec comme destination prévue le point (3.0,6.5)
	PlannedRide planned_ride = new PlannedRide(user, 3.0,6.5,"electrical",system);

	@Test
	public void testGetStartingStation() { //on s'attend ici a voir la station 2
		assertTrue(planned_ride.getStartingStation().equals(system.getSystemStations().get(1))); //la station n°2 est celle d'indice 1
	}

	@Test
	public void testGetEndingStation() { //on s'attend ici a voir la station 7
		assertTrue(planned_ride.getEndingStation().equals(system.getSystemStations().get(5)));  //la station n°6 est celle d'indice 5
	}

}
