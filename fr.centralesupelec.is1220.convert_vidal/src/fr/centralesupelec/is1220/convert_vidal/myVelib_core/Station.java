package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

import java.util.ArrayList;

public class Station implements Observer{
	private double x_gps;
	private double y_gps;
	private boolean onService;
	private int stationSize;  //nombre de slots de la station
	private String type;
	private ArrayList<ParkingSlot> slots; //liste de slots composant une station
	private int idStation; //a modifier si singleton pattern
	// rajouter objet terminal quand la classe aura ete cr��e
	
	
	public Station(double x_gps, double y_gps, boolean onService, String type, int idStation, int stationSize) {
		super();
		this.x_gps = x_gps;
		this.y_gps = y_gps;
		this.onService = onService;
		this.stationSize = stationSize;
		this.type = type;
		this.idStation = idStation;
		this.slots = new ArrayList<ParkingSlot>();
		for (int i = 0; i < stationSize; i++) {
			ParkingSlot slot = new ParkingSlot("free");
			this.slots.add(slot);
		}
		// a continuer
		//j'aimerai impl�menter ici la fonction qui cr�e une liste de slots de taille stationSize
		}


	public double getX_gps() {
		return x_gps;
	}


	public void setX_gps(double x_gps) {
		this.x_gps = x_gps;
	}


	public double getY_gps() {
		return y_gps;
	}


	public void setY_gps(double y_gps) {
		this.y_gps = y_gps;
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


	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}


	@Override
	public String toString() {
		return "The Station n�" +idStation +" of type " + type + " is " + (onService? "on service " : "out of order ") + "and has "+ stationSize + " slots";
	}


	@Override
	public void updateBalance(Bike bike) {
		
	}


	@Override
	public void updateStation(Bike bike, String movement) {
		if (movement == "rent") {
			for (ParkingSlot slot : this.slots) {
				if (slot.getBike()==bike) {
					slot.setState("free");
					slot.setBike(null);
					int k = slot.getIdSlot()-1;
					this.slots.set(k, slot);
				}
			}
		}
		else if (movement == "drop") {
			int k = 0;
			boolean flag  = false;
			for (ParkingSlot slot : this.slots) {
				while (flag == false) {
					if (slot.getState() == "free") {
						slot.setState("full");
						slot.setBike(bike);
						this.slots.set(k, slot);
						flag = true;
					}
					else {
						k++;
					}
				}
			}
		}
	}
	
	public double distance(Station station) {
		return Math.hypot(this.x_gps - station.getX_gps(), this.y_gps - station.getY_gps());
	}
	
	
	
	
}