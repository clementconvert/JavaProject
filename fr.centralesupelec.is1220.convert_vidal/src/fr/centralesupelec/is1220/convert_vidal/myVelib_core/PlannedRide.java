package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

import java.util.ArrayList;

public class PlannedRide {
	private User user;
	private double x_destination;
	private double y_destination; // Les coordonnées de la destination du user
	private Station startingStation;
	private Station endingStation;
	private double bestStartingDistance;
	private double bestEndingDistance;
	private String typeBike; //Le type de velo souhaité par l'utilisateur
	private ArrayList<Station> bestStations; 

	
	public ArrayList<Station> bestStations(ArrayList<Station> stations){
		
		//On ajoutera nos stations à cet arrayList
		for (Station station : stations) {
		
			double startingDistance = station.distance(user); //On calcule la distance entre chaque station et le uer
		
			if (startingDistance < bestStartingDistance && station.existTypeBike(typeBike)) {
				bestStartingDistance = startingDistance;
				startingStation = station;
			}
		
			double endingDistance = Math.hypot(station.getX_gps() - x_destination, station.getY_gps() - y_destination);
		 
			if (endingDistance < bestEndingDistance && station.existFreeSlot()) {
				endingStation = station;
				bestEndingDistance = endingDistance;
			}
		}
		
		bestStations.add(startingStation);
		bestStations.add(endingStation);
	
		return bestStations;
	}
	
}
	
	

	

