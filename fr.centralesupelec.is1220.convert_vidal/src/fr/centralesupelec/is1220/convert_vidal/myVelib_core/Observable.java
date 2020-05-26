package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public interface Observable {
	
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();

}
