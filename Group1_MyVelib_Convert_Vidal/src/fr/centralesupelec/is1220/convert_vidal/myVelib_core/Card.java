package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Card implements CardPrice{
	private double timeBalance;
	
	
	public Card() {
		super();
		this.timeBalance = 0.0; //When we generate a new card, the time balance is automatically set to 0
	}


	@Override
	public String toString() {
		return "Card time balance : " + timeBalance + " min";
	}


	public double getTimeBalance() {
		return timeBalance;
	}


	public void setTimeBalance(double timeBalance) {
		this.timeBalance = timeBalance;
	}
	
	public void addTimeBalance(double timeCredit) {
		this.timeBalance+=timeCredit;
	}


	@Override
	public double cost(Ride ride) {
		// TODO Auto-generated method stub
		return 0;
	}

	//We do not generate a setCardType because once the card is created one cannot change its type.
	
	
	

}
