package test;

import controller.AbstractController;
import jssc.SerialPortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArduinoTestController extends AbstractController {

    /* Static Variables */

    /* Static Methods */

    /* Object Variables */

    /* Constructors */

    /* Object Methods */
    @Override
    protected void werteDatenAus() {
        System.out.println(data);
        data = "";
    }

    @Override
    public void disconnect() {
        try {
            serialPort.closePort();
        } catch (SerialPortException e) {
            System.err.println(e);
        }
    }


    /* Getters and Setters */
    @Override
    public double getJoystickX() {
        return 0;
    }

    @Override
    public double getJoystickY() {
        return 0;
    }

    @Override
    public boolean getA() {
        return false;
    }

    @Override
    public boolean getB() {
        return false;
    }

    /* Inner Classes */

}
