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


}
