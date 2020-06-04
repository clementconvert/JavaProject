package myVelib_core;

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
		ParkingSlot associatedSlot = null;
		
		for (ParkingSlot slot : slots) {
			if (slot.getBike().getBikeType() == bikeType) {
				associatedSlot = slot;
				break;
			}
		}
		return associatedSlot;
	}
		
	public int getNumberOfOperations() {
		return numberOfOperations;
	}
	
	public ParkingSlot getFreeSlot() {
		ParkingSlot freeSlot = null;
		for (ParkingSlot slot : slots) {
			if (slot.getState()=="free") {
				freeSlot = slot;
				break;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStation;
		result = prime * result + numberOfOperations;
		result = prime * result + (onService ? 1231 : 1237);
		result = prime * result + ((slots == null) ? 0 : slots.hashCode());
		result = prime * result + stationSize;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(x_gps);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y_gps);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (idStation != other.idStation)
			return false;
		if (numberOfOperations != other.numberOfOperations)
			return false;
		if (onService != other.onService)
			return false;
		if (slots == null) {
			if (other.slots != null)
				return false;
		} else if (!slots.equals(other.slots))
			return false;
		if (stationSize != other.stationSize)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(x_gps) != Double.doubleToLongBits(other.x_gps))
			return false;
		if (Double.doubleToLongBits(y_gps) != Double.doubleToLongBits(other.y_gps))
			return false;
		return true;
	}
}

