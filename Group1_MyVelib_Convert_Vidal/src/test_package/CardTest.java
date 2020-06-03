package test_package;

import static org.junit.Assert.*;

import org.junit.Test;

import myVelib_core.NoCard;
import myVelib_core.Ride;
import myVelib_core.Station;
import myVelib_core.User;
import myVelib_core.Vlibre;
import myVelib_core.Vmax;

public class CardTest {
	
	Station arrival = new Station(1,2,true, "plus", 10);  //on crée une station d'arrivée et une de départ
	Station departure = new Station(7,5,true, "standard", 10);
	
	Vlibre vlibre = new Vlibre();
	Vmax vmax = new Vmax();
	NoCard noCard = new NoCard(); //on crée une carte car le constructeur de user nécessite une carte
	
	User pichard = new User("Pichard", 0, 0, 2, noCard); //on crée un 1er user sans carte
	User michel = new User("Michel",0,0,3, vmax); //on crée un autre user avec une carte vmax
	User bouchon = new User("Bouchon",0,0,12,vlibre); //on crée un autre user avec une carte vlibre
	
	Ride ride1 = new Ride(departure, "electrical", pichard);
	Ride ride2 = new Ride(departure, "mechanical", michel);
	Ride ride3 = new Ride(departure, "mechanical", bouchon);
	


	@Test
	public void testAddTimeBalance() {
		vmax.addTimeBalance(10);  //on ajoute 10 credits a la carte qui au depart n'a 0 credit
		assertTrue(vmax.getTimeBalance()==10);
	}

	@Test
	public void testCostNocard() {
		ride1.setArrival(arrival);
		double duration = Math.sqrt(45)*60/15; //sqrt(45) est la distance et 15kmh la vitesse
		double cost = duration*2/60; //*2 car 2e de l'heure en vélo electrique et /60 pour convertir duration de min en h
		assertTrue(noCard.cost(ride1)==cost);
	}
	
	@Test
	public void testCostVlibre() {
		ride3.setArrival(arrival);
		double duration = Math.sqrt(45)*60/15; //sqrt(45) est la distance et 15kmh la vitesse
		double cost = 0; //0 car la durée est inférieure à 1h donc avec Vlibre c'est gratuit
		assertTrue(vlibre.cost(ride3)==cost && vlibre.getTimeBalance()==5);  //on arrive a une station plus donc on doit gagner 5min de credit
	}
	
	@Test
	public void testCostVmax() {
		ride2.setArrival(arrival);
		double duration = Math.sqrt(45)*60/15; //sqrt(45) est la distance et 15kmh la vitesse
		double cost = 0; //durée inférieure a 0
		assertTrue(vmax.cost(ride2)==cost && vmax.getTimeBalance()==5);
	}

}
