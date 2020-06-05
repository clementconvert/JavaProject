package myVelib_core;

public class Card implements CardPrice{
	private double timeBalance;
	private int count;
	private int idCard;
	
	
	public Card() {
		super();
		count++;
		this.timeBalance = 0.0; //When we generate a new card, the time balance is automatically set to 0
		this.idCard=count;
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


	public int getIdCard() {
		return idCard;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCard;
		long temp;
		temp = Double.doubleToLongBits(timeBalance);
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
		Card other = (Card) obj;
		if (idCard != other.idCard)
			return false;
		if (Double.doubleToLongBits(timeBalance) != Double.doubleToLongBits(other.timeBalance))
			return false;
		return true;
	}

	//We do not generate a setCardType because once the card is created one cannot change its type.
	
	
	

}
