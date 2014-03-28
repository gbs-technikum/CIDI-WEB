package de.cidi;

import com.pi4j.io.gpio.impl.GpioControllerImpl;

public class Controller {

	private static Controller instance = new Controller();
	
	
	
	private Controller() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	public static Controller getInstance(){
		
		return instance;
	}
	
	public void foo(){
		
	}
	
}
