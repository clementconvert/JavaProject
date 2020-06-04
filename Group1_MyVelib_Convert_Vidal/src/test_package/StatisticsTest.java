package test_package;

import static org.junit.Assert.*;

import org.junit.Test;

import myVelib_core.MyVelib;
import myVelib_core.NoCard;
import myVelib_core.Statistics;
import myVelib_core.User;
import myVelib_core.Vmax;

public class StatisticsTest {
	
	MyVelib system = new MyVelib();
	
	NoCard noCard1 = new NoCard();
	Vmax vmax = new Vmax();
	
	User michel = new User("Michel",0,0,2,noCard1);
	User pichard = new User("Pichard",0,0,3,vmax);
	
	

	@Test
	public void testFindUser() {
		system.addUser(michel);
		system.addUser(pichard);
		Statistics stats = new Statistics(system);
		int id = michel.getId();
		assertTrue(stats.findUser(id).equals(michel));
	}

	@Test
	public void testFindStation() {
		Statistics stats = new Statistics(system);
		assertTrue(stats.findStation(2).equals(system.getSystemStations().get(1)));  //on verifie que lorsqu'on appelle la station d'id 2 on tombe sur la 2e station de la liste
	}

	@Test
	public void testGetUserBalance() {
		system.addUser(michel);  //on ajoute des users au myVelib
		system.addUser(pichard);
		Statistics stats = new Statistics(system); //on crée l'objet stats avec la liste des users
		int id = michel.getId();
		double time1 = Math.sqrt(9+6.5*6.5)*60/15; //it's the time spent on the bike during the ride
		double cost = time1/60;
		
		michel.rentBike(michel, 3.0, 6.5, "electrical", system); //on fait faire une ride a michel pour voir si on modifie bien tous les parametres demandés
		michel.dropBike(michel, "electrical", system);
		
		assertTrue(stats.getUserBalance(id)=="Michel has done 1 rides, spent "+time1+" mins on a bike. He has been Charged " + cost +"$ and has 0 mins in time credit");
		}

	@Test
	public void testGetStationBalance() {
		system.addUser(michel);  //on ajoute des users au myVelib
		system.addUser(pichard);
		int idDeparture = 2; //on part de la station2
		int idArrival = 6; //on arrive a la 6
		Statistics stats = new Statistics(system); //on crée l'objet stats avec la liste des users
		michel.rentBike(michel, 3.0, 6.5, "electrical", system); //on fait faire une ride a michel pour voir si on modifie bien tous les parametres demandés
		michel.dropBike(michel, "electrical", system);
		System.out.println(stats.getStationBalance(idDeparture));
		assertTrue(stats.getStationBalance(idDeparture)=="Station has been used 1 times." && stats.getStationBalance(idArrival)=="Station has been used 1 times.");
	}

	@Test
	public void testMostUsedStation() {
		fail("Not yet implemented");
	}

}
