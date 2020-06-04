package test_package;

import static org.junit.Assert.*;

import org.junit.Test;

import myVelib_core.MyVelib;
import myVelib_core.NoCard;
import myVelib_core.ParkingSlot;
import myVelib_core.User;

public class UserTest {
	
	MyVelib system = new MyVelib(); //on cr�e un systeme myVelib compos� de 10 stations, plac�es 
    //al�atoirement et remplies a 70% de v�los
	
	NoCard noCard1 = new NoCard();
	NoCard noCard2 = new NoCard();
	
	User michel = new User("Michel",0,0,2,noCard1);
	User pichard = new User("Pichard",0,0,3,noCard2);
	//dans la fonction rent on utilise la fonctionnalit� planRide.
	//on a vu dans TestPlannedRide que les stations de d�part et d'arriv�e conseill�es pour
	//une destination (3.0,6.5) etaient les stations 2 et 6

	@Test
	public void testRentBike() {
		michel.rentBike(michel, 3.0, 6.5, "electrical", system); //on s'attend a ce que le slot n�7 devienne vide
		ParkingSlot expectedSlot = system.getSystemStations().get(1).getSlots().get(5);
		assertTrue(expectedSlot.getState()=="free");
		
	}

	@Test
	public void testDropBike() {
		michel.rentBike(michel, 3.0, 6.5, "electrical", system); //pour pouvoir drop il faut avoir rent avant sinon la dropStation vaut null
		michel.dropBike(michel,"electrical", system); //on s'attend a ce que le slot n�8 devienne occup�
		ParkingSlot expectedSlot = system.getSystemStations().get(5).getSlots().get(7);
		assertTrue(expectedSlot.getState()=="full");
	}

}
