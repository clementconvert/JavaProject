package myVelib_core;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bike == null) ? 0 : bike.hashCode());
		result = prime * result + idSlot;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		ParkingSlot other = (ParkingSlot) obj;
		if (bike == null) {
			if (other.bike != null)
				return false;
		} else if (!bike.equals(other.bike))
			return false;
		if (idSlot != other.idSlot)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
