package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

import java.util.ArrayList;

public class User {
	private double x_gps;
	private double y_gps;
	private String name;
	private static int counter; //As for the bank exercise, this assure us to give a unique id per user
	private int id;
	private int creditCard;//The credit card will be registered with the account number
	private Card card;
	private double balance;//This will be the money debt the user has
	private boolean  onBike; //We should record whenever a user is using a bike
	private Station rentStation;
	private Station dropStation;
	private int numberOfRents;

	public User(String name, double x_gps, double y_gps, int creditCard, Card card) { //One can create a null card if he doesn't want one
		super();
		this.x_gps = x_gps;
		this.y_gps = y_gps;
		this.counter++;
		this.name = name;
		this.id = this.counter;
		this.creditCard = creditCard;
		this.card = card;
		this.balance = 0.0; // When we create a user his charges ar automatically set to 0
		this.onBike = false;//When we create a user, he has not yet rented a bike
		this.dropStation = null; // both will be used to register the trip of the bike (from where to where)
		this.rentStation = null;
		this.numberOfRents =0;
	}

	@Override
	public String toString() {
		return "User n°" + id + ", Name:  " + name + ", registered with credit card n°" + creditCard + ", owner of a " + card + " card. Charges :"
				+ balance + " $";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
    public Station getRentStation() {
		return rentStation;
	}

	public Station getDropStation() {
		return dropStation;
	}

	public void setDropStation(Station dropStation) {
		this.dropStation = dropStation;
	}

	public void setRentStation(Station rentStation) {
		this.rentStation = rentStation;
	}
	
	public boolean isOnBike() {
		return onBike;
	}

	public void setOnBike(boolean onBike) {
		this.onBike = onBike;
	}
	
	public int getNumberOfRents() {
		return numberOfRents;
	}

	public void setNumberOfRents(int numberOfRents) {
		this.numberOfRents = numberOfRents;
	}

	public void rentBike(User user, double x_destination, double y_destination, String bikeType, MyVelib system) {
        // Planning returns a station where there is a bicycle, we don't need to check again
		PlannedRide planned_ride = new PlannedRide(user, x_destination, y_destination,bikeType,system);
		Station startingStation = planned_ride.getStartingStation();
		Station endingStation = planned_ride.getEndingStation();

        // A user can only rent 1 bicycle
        if (this.isOnBike()== true) {
            System.out.println("You already have a bike");
        }
        else {
            System.out.println("Here you go!");
            if (bikeType=="electrical") {
                System.out.println("An electrical bike");
            } else if (bikeType=="mechanical") {
                System.out.println("A mechanical bike");
            }

            // Set hasBicycle = true and register which station the bike comes from
            setOnBike(true);
            setRentStation(startingStation);
            setDropStation(endingStation);

            // Change the state of parkingSlot and Station
            ParkingSlot slot = startingStation.getSlotbyBike(bikeType);
            slot.setState("free");
            slot.setBike(null);
            startingStation.setNumberOfOperations(startingStation.getNumberOfOperations()+1);
        }
	}
	
	public void dropBike(User user, String bikeType, MyVelib system) {
		 // Compute the journey
        Ride ride = new Ride(user.getRentStation(),bikeType,user);
        ride.setArrival(user.getDropStation());
        
        // Compute the rent cost for the user
        double price = user.getCard().cost(ride);
        
        // Take the money of the user !!!!
        user.setBalance(user.getBalance() + price);  //on ajoute le prix de la course, ainsi la balance est en fait le prix cumulé de tous les trajets

        // Set hasBicycle = true and rentStationID in User
        user.setOnBike(false);
        user.setRentStation(null); //on réinitialise la station de départ
        

        // Change the state of parkingSlot and station
        ParkingSlot slot = user.getDropStation().getFreeSlot();
        slot.setState("full");
        slot.setBike(new Bike(bikeType));
        dropStation.setNumberOfOperations(dropStation.getNumberOfOperations()+1); //on incrémente le nbre d'opérations
        user.setDropStation(null); //on réinitialise la station d'arrivée

        // Return bicycle
        System.out.println("You trip is finalized!");

        user.setNumberOfRents(user.getNumberOfRents()+1);

    }

	

}

