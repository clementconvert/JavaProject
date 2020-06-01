package fr.centralesupelec.is1220.convert_vidal.myVelib_core;

public class SerialNumberGenerator {//On a besoin de ceci pour avoir un unique identifiant pour les vélos


	private static SerialNumberGenerator instance = null;
	private int num;
	
	private SerialNumberGenerator(){}
	
	public static SerialNumberGenerator getInstance() {
		if (instance==null) {
				instance = new SerialNumberGenerator();
		}
		return instance;
	}
	
	public int getNextSerialNumber(){
		return num++;
	}
}
