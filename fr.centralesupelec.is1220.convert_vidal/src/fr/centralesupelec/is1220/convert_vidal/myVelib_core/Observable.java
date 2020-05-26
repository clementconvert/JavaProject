package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public interface Observable {
	
	public void registerStation(Station station);
	public void removeStation(Station station);
	public void notifyStation(Station updated_station, Bike bike, String movement);
	public void registerCard(Card card);
	public void removeCard(Card card);
	public void notifyCard();

}
