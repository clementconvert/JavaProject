package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class ParkingSlot {
	private static int count;
	private int idSlot;  // a modifier si on utilise un singleton pattern
	private String state; // "full" "out of service" "free"
	private Bike bike;   //on lui attribue le velo qu'il contient ou null s'il n'y en a pas
	
	public ParkingSlot() {
		super();
		count++;
		this.state = "free";
		this.idSlot=this.count; 
		this.bike = null;
	}

	public int getIdSlot() {
		return idSlot;
	}

	public void setIdSlot(int idSlot) {
		this.idSlot = idSlot;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	@Override
	public String toString() {
		return " The parking slot n°" + idSlot + " is " + state;
	}

}
