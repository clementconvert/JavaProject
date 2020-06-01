package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

import java.util.ArrayList;

public class Station{
	private static int count;
	final double x_gps;
	final double y_gps;
	private boolean onService;
	private int stationSize;  //nombre de slots de la station
	private String type;
	private ArrayList<ParkingSlot> slots; //liste de slots composant une station
	final int idStation; //a modifier si singleton pattern
	private int numberOfOperations;  //pour pouvoir calculer a la fin le nombre d'operations de drop et rent
	
	
	public Station(double x_gps, double y_gps, boolean onService, String type, int stationSize) {
		super();
		count++;
		this.x_gps = x_gps;
		this.y_gps = y_gps;
		this.onService = onService;
		this.stationSize = stationSize;
		this.type = type;
		this.idStation = Station.count;
		this.numberOfOperations = 0;
		this.slots = new ArrayList<ParkingSlot>();
		for (int i = 0; i < stationSize; i++) {// fonction qui crée une liste de slots de taille stationSize
			ParkingSlot slot = new ParkingSlot();
			this.slots.add(slot);
		}
		
		}


	public double getX_gps() {
		return x_gps;
	}

	public double getY_gps() {
		return y_gps;
	}

	public boolean isOnService() {
		return onService;
	}


	public void setOnService(boolean onService) {
		this.onService = onService;
	}


	public int getStationSize() {
		return stationSize;
	}


	public void setStationSize(int stationSize) {
		this.stationSize = stationSize;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public ArrayList<ParkingSlot> getSlots() {
		return slots;
	}


	public void setSlots(ArrayList<ParkingSlot> slots) {
		this.slots = slots;
	}


	public int getIdStation() {
		return idStation;
	}

	public ParkingSlot getSlotbyBike(String bikeType) {
		ParkingSlot associatedSlot = new ParkingSlot();
		try {
		for (ParkingSlot slot : slots) {
			if (slot.getBike().getBikeType() == bikeType) {
				associatedSlot = slot;
			}
		}
		}catch(NullPointerException e) {
			System.out.println("Slot is free");
		}finally {
		return associatedSlot;}
	}
	public int getNumberOfOperations() {
		return numberOfOperations;
	}
	
	public ParkingSlot getFreeSlot() {
		ParkingSlot freeSlot = new ParkingSlot();
		for (ParkingSlot slot : slots) {
			if (slot.getState()=="free") {
				freeSlot = slot;
			}
		}
		return freeSlot;
	}


	public void setNumberOfOperations(int numberOfOperations) {
		this.numberOfOperations = numberOfOperations;
	}


	@Override
	public String toString() {
		return "The Station n°" +idStation +" of type " + type + " is " + (onService? "on service " : "out of order ") + "and has "+ stationSize + " slots";
	}
	
	public double distance(Station station) {
		return Math.hypot(this.x_gps - station.getX_gps(), this.y_gps - station.getY_gps());
	}
	
	public double distance(User user) {
		return Math.hypot(this.x_gps - user.getX_gps(), this.y_gps - user.getY_gps());
	}
	
	public boolean existTypeBike(String typeBike) { //On a besoin de cette méthode pour PlannedRide
		for (ParkingSlot slot : slots) {
			if (slot.getBike().getBikeType() == typeBike)
					return true;
		}
		return false;
		}
	
	public boolean existFreeSlot() { //De la mÃªme maniÃ¨re on utilisera cette fonction dans PlannedRide
		for (ParkingSlot slot : slots) {
			if (slot.getState() == "free")
				return true;
		}
		return false;
	}
}

