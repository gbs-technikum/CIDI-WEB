package de.cidi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Controller {

	private static Controller instance = new Controller();
	final GpioController gpio;
	private GpioPinDigitalOutput pinleft, pinright, pinup, pindown, pinalicht, pinflicht, pinhupe;

	private Controller() {
		// TODO Auto-generated constructor stub
		gpio = GpioFactory.getInstance();
		
		// left
		pinleft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
		// right
		pinright = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00,PinState.LOW);

		// up
		pinup = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
		// down
		pindown = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
		
		//alicht
		pinalicht = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, PinState.LOW);
		
		//flicht
		pinflicht = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW);
		
		//hupe
		pinhupe = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, PinState.LOW);
		
	}

	public static Controller getInstance() {
		return instance;
	}

	public void drive(boolean left, boolean right, boolean up, boolean down, boolean flicht, boolean alicht, boolean hupe) {
		
		pinleft.setState(left);
		pinright.setState(right);
		pinup.setState(up);
		pindown.setState(down);
		pinalicht.setState(alicht);
		pinflicht.setState(flicht);
		pinhupe.setState(hupe);
		
	}
	
	public void close(){
		pinleft.setState(false);
		pinright.setState(false);
		pinup.setState(false);
		pindown.setState(false);
		pinalicht.setState(false);
		pinflicht.setState(false);
		pinhupe.setState(false);
		gpio.shutdown();
	}

}
