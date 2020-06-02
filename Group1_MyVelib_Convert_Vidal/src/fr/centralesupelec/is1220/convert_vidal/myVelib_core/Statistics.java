package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

import java.util.ArrayList;

public class Statistics {
	private ArrayList<User> users;
	private ArrayList<Station> stations;
	
	
	public Statistics(MyVelib system) { //on crée nos listes a partir du systeme MyVelib
		super();
		this.users = system.getUsers();
		this.stations = system.getSystemStations();
	}


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public ArrayList<Station> getStations() {
		return stations;
	}


	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}
	
	public User findUser(int userId) {
		User found = null;
		for (User user : this.users) {
			if (user.getId() == userId) {
				found = user;
			}
		}
		return found;
	}
	
	public Station findStation(int stationId) {
		Station found = null;
		for (Station station : this.stations) {
			if (station.getIdStation() == stationId) {
				found = station;
			}
		}
		return found;
	}
	
	public String getUserBalance(int userId) {
		User user = findUser(userId);
		int numberOfRides = user.getNumberOfRents();  //we get the number of rides that is incremented each time user drops a bike
		double timeSpentOnBike = user.getTimeSpentOnBike(); //same with time on bike
		double amountOfCharges = user.getBalance();  //same with balance
		double timeCredit = user.getCard().getTimeBalance();  //we look for the time credit which is an attribute of Card
		return user.getName() + " has done " + numberOfRides + " rides, spent " + timeSpentOnBike + " mins on a bike. He's been Charged "
				+ amountOfCharges + "$ and has " + timeCredit + " mins in time credit";
	}
	
	public String getStationBalance(int stationId) {
		Station station = findStation(stationId);
		int numberOfOperations = station.getNumberOfOperations();
		return "Station has been used " + numberOfOperations + " times.";
	}
	
	public Station mostUsedStation() {
		Station mostUsed = new Station(0,0,true,"Standard",10); //on crée une station fictive avec 0 utilisations plutot qu'une station null sinonprobleme au niveau du getNbofOperations dans le if au debut
		for (Station station : stations) {
			if (station.getNumberOfOperations()>mostUsed.getNumberOfOperations()) {
				mostUsed = station;
			}
		}
		return mostUsed;		
	}


}
