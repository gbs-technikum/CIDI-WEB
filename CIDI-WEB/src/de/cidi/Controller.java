package de.cidi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Controller {

	private static Controller instance = new Controller();
	final GpioController gpio;
	private GpioPinDigitalOutput pinleft, pinright, pinup, pindown, pinalicht,
			pinrlicht, pinflicht, pinrflicht;

	private Controller() {
		// TODO Auto-generated constructor stub
		gpio = GpioFactory.getInstance();

		// Pins Inizialisieren
		// left
		pinleft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
		// right
		pinright = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03,PinState.LOW);

		// up
		pinup = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
		// down
		pindown = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);

		// alicht - rlicht
		pinalicht = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,PinState.LOW);
		
		pinrlicht = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,PinState.LOW);

		// flicht
		pinflicht = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05,PinState.LOW);

		// rückfahrlicht
		pinrflicht = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06,PinState.LOW);

	}

	public static Controller getInstance() {
		return instance;
	}

	// boolean werte von SENTDATA entgegennehmen und an die Pins übergeben
	public void drive(boolean left, boolean right, boolean up, boolean down,boolean flicht, boolean alicht) {
		pinleft.setState(left);
		pinright.setState(right);
		pinup.setState(up);
		pindown.setState(down);
		pinalicht.setState(alicht);
		pinrlicht.setState(alicht);
		pinflicht.setState(flicht);
		pinrflicht.setState(down);

	}

	// Verbindung zu den Pins schließen
	public void close() {
		pinleft.setState(false);
		pinright.setState(false);
		pinup.setState(false);
		pindown.setState(false);
		pinalicht.setState(false);
		pinrlicht.setState(false);
		pinflicht.setState(false);
		pinrflicht.setState(false);
		gpio.shutdown();
	}

}
