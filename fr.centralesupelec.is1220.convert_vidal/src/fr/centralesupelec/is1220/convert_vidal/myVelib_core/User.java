package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class User {
	private double x_gps;
	private double y_gps;
	private String name;
	private static int counter; //As for the bank exercise, this assure us to give a unique id per user
	private int id;
	private int creditCard;//The credit card will be registered with the account number
	private Card card;
	private double balance;//This will be the money debt the user has
	private Bike bike; //We should record whenever a user is using a bike 
	
	public User(String name, int creditCard, Card card) { //One can create a null card if he doesn't want one
		super();
		this.x_gps = x_gps;
		this.y_gps = y_gps;
		this.counter++;
		this.name = name;
		this.id = this.counter;
		this.creditCard = creditCard;
		this.card = card;
		this.balance = 0.0; // When we create a user his charges ar automatically set to 0
		this.bike = null;//When we create a user, he has not yet rented a bike
	}

	@Override
	public String toString() {
		return "User n°" + id + ", Name:  " + name + ", registered with credit card n°" + creditCard + ", owner of a " + card + " card. Charges :"
				+ balance + " €";
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

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	
	
	

}
