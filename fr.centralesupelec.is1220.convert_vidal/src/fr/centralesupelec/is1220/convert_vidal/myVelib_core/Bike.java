package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Bike {
	private int id;
	private BikeType bikeType;
	private static int counter;//We also want each bike to have a unique id
	
	public Bike(BikeType bikeType) {
		super();
		counter++;
		this.id = counter;
		this.bikeType = bikeType;
	}

	public Bike() {
		super();
	}

	@Override
	public String toString() {
		return "Bike n°" + id + " is a " + bikeType + "bike";
	}

	//Once the bike is created, one cannot set its id nor its type
	public int getId() {
		return id;
	}

	public BikeType getBikeType() {
		return bikeType;
	}
	
	
	

}
