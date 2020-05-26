package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Bike {
	private int id;
	private String bikeType;
	private SerialNumberGenerator gen = SerialNumberGenerator.getInstance();//We also want each bike to have a unique id
	
	public Bike(String bikeType) {
		super();
		this.id = gen.getNextSerialNumber();
		this.bikeType = bikeType;
	}

	public Bike() {
		super();
	}

	@Override
	public String toString() {
		return "Bike n°" + id + " is a " + bikeType + " bike";
	}

	//Once the bike is created, one cannot set its id nor its type
	public int getId() {
		return id;
	}

	public String getBikeType() {
		return bikeType;
	}
	

}
