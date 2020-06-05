package myVelib_core;

public class PlannedRide {
	private User user;
	private double x_destination;
	private double y_destination; // Les coordonnées de la destination du user
	private Station startingStation;
	private Station endingStation;
	private String typeBike; //Le type de velo souhaité par l'utilisateur
	
	
	public PlannedRide(User user, double x_destination, double y_destination, String typeBike, MyVelib system){
		this.user = user;
		this.x_destination = x_destination;
		this.y_destination = y_destination;
		this.typeBike = typeBike;
		double bestStartingDistance = 100;
		double bestEndingDistance = 100;
		for (Station station : system.getSystemStations()) {
		
			double startingDistance = station.distance(user); //On calcule la distance entre chaque station et le uer
		
			if (startingDistance < bestStartingDistance && station.existTypeBike(this.typeBike)) {
				bestStartingDistance = startingDistance;
				this.startingStation = station;
			}
		
			double endingDistance = Math.hypot(station.getX_gps() - this.x_destination, station.getY_gps() - this.y_destination);
		 
			if (endingDistance < bestEndingDistance && station.existFreeSlot()) {
				this.endingStation = station;
				bestEndingDistance = endingDistance;
			}
		}
	
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public double getX_destination() {
		return x_destination;
	}


	public void setX_destination(double x_destination) {
		this.x_destination = x_destination;
	}


	public double getY_destination() {
		return y_destination;
	}


	public void setY_destination(double y_destination) {
		this.y_destination = y_destination;
	}


	public Station getStartingStation() {
		return startingStation;
	}


	public void setStartingStation(Station startingStation) {
		this.startingStation = startingStation;
	}


	public Station getEndingStation() {
		return endingStation;
	}


	public void setEndingStation(Station endingStation) {
		this.endingStation = endingStation;
	}


	public String getTypeBike() {
		return typeBike;
	}


	public void setTypeBike(String typeBike) {
		this.typeBike = typeBike;
	}
	
	
}
	
	

	

