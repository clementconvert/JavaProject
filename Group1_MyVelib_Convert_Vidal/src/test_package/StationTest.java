package test_package;

import static org.junit.Assert.*;

import org.junit.Test;

import myVelib_core.Bike;
import myVelib_core.NoCard;
import myVelib_core.ParkingSlot;
import myVelib_core.Station;
import myVelib_core.User;

public class StationTest {
	
	Station station1 = new Station(0,0,true, "standard",10); //on crée trois stations pour le test
	Station station2 = new Station(2,0,true, "standard",10);
	Station station3 = new Station(1,3,true,"standard",10);

	@Test
	public void testGetSlotbyBike() {
		for (int j = 0; j < 5; j++) { //on remplit 70% des slots dont 30% avec des vélos electriques (7 velos par stations, 5 normaux, 2 elec)
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("mechanical");
			slot.setBike(bike);
			slot.setState("full");
			}
		for (int j = 5; j < 7; j++) {
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("electrical");
			slot.setBike(bike);
			slot.setState("full");
			}
		ParkingSlot slotElectrical = station1.getSlots().get(5); //on met l'indice 5 car la fonction getSLot prend toujours le premier slot ou il y a un velo du type demandé
		
		ParkingSlot slotMechanical = station1.getSlots().get(0); //on met l'indice 0 car on s'attend a avoir le slot en position 1(donc indice 1-1) car les 5 premiers slots contiennent des velos mecaniques
		
		assertTrue(station1.getSlotbyBike("electrical").equals(slotElectrical));
		assertTrue(station1.getSlotbyBike("mechanical").equals(slotMechanical));
	}

	@Test
	public void testGetFreeSlot() {
		for (int j = 0; j < 5; j++) { //on remplit 70% des slots dont 30% avec des vélos electriques (7 velos par stations, 5 normaux, 2 elec)
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("mechanical");
			slot.setBike(bike);
			slot.setState("full");
			}
		for (int j = 5; j < 7; j++) {
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("electrical");
			slot.setBike(bike);
			slot.setState("full");
			}
		ParkingSlot freeSlot = station1.getSlots().get(7); //encore une fois getFreeSlot prend le premier slot de libre
		assertTrue(station1.getFreeSlot().equals(freeSlot));
	}

	@Test
	public void testDistanceStation() {
		assertTrue(station1.distance(station2)==2.0); //teste la distance entre les stations
		assertTrue(station2.distance(station3)==Math.sqrt(10));
	}

	@Test
	public void testDistanceUser() {
		NoCard noCard = new NoCard(); //on crée une carte car le constructeur de user nécessite une carte
		User user = new User("Pichard", 4, 5, 2, noCard); 
		assertTrue(station1.distance(user)==Math.sqrt(41));
		assertTrue(station3.distance(user)==Math.sqrt(13));
	}

	@Test
	public void testExistTypeBike() {
		for (int j = 0; j < 5; j++) { //on remplit 70% des slots dont 30% avec des vélos electriques (7 velos par stations, 5 normaux, 2 elec)
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("mechanical");
			slot.setBike(bike);
			slot.setState("full");
			}
		for (int j = 5; j < 7; j++) {
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("electrical");
			slot.setBike(bike);
			slot.setState("full");
			}
		assertTrue(station1.existTypeBike("electrical")==true);
		assertTrue(station1.existTypeBike("mechanical")==true);
	}

	@Test
	public void testExistFreeSlot() {
		for (int j = 0; j < 5; j++) { //on remplit 70% des slots dont 30% avec des vélos electriques (7 velos par stations, 5 normaux, 2 elec)
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("mechanical");
			slot.setBike(bike);
			slot.setState("full");
			}
		for (int j = 5; j < 7; j++) {
			ParkingSlot slot = station1.getSlots().get(j);
			Bike bike = new Bike("electrical");
			slot.setBike(bike);
			slot.setState("full");
			}
		for (int j = 0; j < 10; j++) { //on crée une station remplie de vélos pour vérifier qu'il n'existe pas de free slot
			ParkingSlot slot = station2.getSlots().get(j);
			Bike bike = new Bike("mechanical");
			slot.setBike(bike);
			slot.setState("full");
			}
		assertTrue(station1.existFreeSlot()==true);
		assertTrue(station2.existFreeSlot()==false);
	}

}
