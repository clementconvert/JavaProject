package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class Card {
	private CardType cardType;
	private double timeBalance;
	
	
	public Card(CardType cardType) {
		super();
		this.cardType = cardType;
		this.timeBalance = 0.0; //When we generate a new card, the time balance is automatically set to 0
	}


	@Override
	public String toString() {
		return "Card type : " + cardType + ", Time balance : " + timeBalance + "min";
	}


	public double getTimeBalance() {
		return timeBalance;
	}


	public void setTimeBalance(double timeBalance) {
		this.timeBalance = timeBalance;
	}

	//We do not generate a setCardType because once the card is created one cannot change its type.
	public CardType getCardType() {
		return cardType;
	}
	
	

}
