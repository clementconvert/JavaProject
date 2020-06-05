package myVelib_core;

public class Bike {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bikeType == null) ? 0 : bikeType.hashCode());
		result = prime * result + ((gen == null) ? 0 : gen.hashCode());
		result = prime * result + id;
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
		Bike other = (Bike) obj;
		if (bikeType == null) {
			if (other.bikeType != null)
				return false;
		} else if (!bikeType.equals(other.bikeType))
			return false;
		if (gen == null) {
			if (other.gen != null)
				return false;
		} else if (!gen.equals(other.gen))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

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
