package myVelib_core;

import java.util.ArrayList;

public class MyVelib {
	private int numberOfStations;
	private int numberOfSlots;
	private double size;
	private ArrayList<Station> systemStations;
	private ArrayList<User> users;
	final static double x_gps[] = {5.910894817799322,
			 0.28924039044196825,
			 6.3270923088948905,
			 5.661825869498874,
			 7.290644889823044,
			 3.0626198529215634,
			 8.792450144332195,
			 3.2882116601813696,
			 8.122268827874773,
			 7.958960871103283};
	final static double y_gps[] = {7.803241812116058,
			 2.0657503592386304,
			 5.142392481664401,
			 5.75217963858499,
			 9.019852372753663,
			 6.0944452276943615,
			 7.414726626646939,
			 7.252497732328194,
			 4.001261903478791,
			 6.6273138729798635};
	
	public MyVelib() {
		super();
		this.numberOfStations = 10;
		this.numberOfSlots = 100;
		this.size = 10.0;  //carré de 10km par 10km
		this.systemStations = new ArrayList<Station>();
		
		for (int i = 0; i < this.numberOfStations/2; i++) {
			Station station = new Station(x_gps[i], y_gps[i],true,"plus",10); //on crée des stations avec 10 slots a chaque fois
			this.systemStations.add(station);
			for (int j = 0; j < 5; j++) { //on remplit 70% des slots dont 30% avec des vélos electriques (7 velos par stations, 5 normaux, 2 elec)
				ParkingSlot slot = station.getSlots().get(j);
				Bike bike = new Bike("mechanical");
				slot.setBike(bike);
				slot.setState("full");
				}
			for (int j = 5; j < 7; j++) {
				ParkingSlot slot = station.getSlots().get(j);
				Bike bike = new Bike("electrical");
				slot.setBike(bike);
				slot.setState("full");
				}
			}
		for (int i = this.numberOfStations/2; i < this.numberOfStations; i++) {
			Station station = new Station(x_gps[i], y_gps[i],true,"standard",10); //on crée la moitié de stations standards et l'autre de type plus
			this.systemStations.add(station);
			for (int j = 0; j < 5; j++) { //on remplit 70% des slots dont 30% avec des vélos electriques (7 velos par stations, 5 normaux, 2 elec)
				ParkingSlot slot = station.getSlots().get(j);
				Bike bike = new Bike("mechanical");
				slot.setBike(bike);
				slot.setState("full");
				}
			for (int j = 5; j < 7; j++) {
				ParkingSlot slot = station.getSlots().get(j);
				Bike bike = new Bike("electrical");
				slot.setBike(bike);
				slot.setState("full");
				}
			}
		this.users = new ArrayList<User>();
	}


	public int getNumberOfStations() {
		return numberOfStations;
	}


	public void setNumberOfStations(int numberOfStations) {
		this.numberOfStations = numberOfStations;
	}


	public int getNumberOfSlots() {
		return numberOfSlots;
	}


	public void setNumberOfSlots(int numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}


	public double getSize() {
		return size;
	}


	public void setSize(double size) {
		this.size = size;
	}


	public ArrayList<Station> getSystemStations() {
		return systemStations;
	}


	public void setSystemStations(ArrayList<Station> systemStations) {
		this.systemStations = systemStations;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void addStation(Station station) {
		this.systemStations.add(station);
	}

	@Override
	public String toString() {
		return "MyVelib has " + numberOfStations + " stations, " + numberOfSlots + " slots and its size is " + size  + " by " + size;
	}

}
	
