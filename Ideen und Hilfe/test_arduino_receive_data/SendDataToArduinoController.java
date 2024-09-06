package test;

import controller.AbstractController;
import jssc.SerialPortException;

import java.io.IOException;

public class SendDataToArduinoController extends AbstractController {

    // Static Variables
    private static final String DELIMITER_ARDUINO_TO_JAVA_START = "#";
    private static final String DELIMITER_ARDUINO_TO_JAVA_END = "?";
    private static final String DELIMITER_JAVA_TO_ARDUINO_START = "^";
    private static final String DELIMITER_JAVA_TO_ARDUINO_END = "!";

    // Static Methods

    // Object Variables

    // Constructors
    public SendDataToArduinoController() {
        super();

        // Wait for the Arduino to initialize
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Object Methods
    @Override
    protected void werteDatenAus() {

        if (!data.contains(DELIMITER_ARDUINO_TO_JAVA_END)) {
            return;
        }

        System.out.println("<<< Received ...");
        System.out.println(data);
        System.out.println("-----------------");
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

    public void sendData(String data) throws SerialPortException {
        System.out.println(">>> Sending ...");
        serialPort.writeString(DELIMITER_JAVA_TO_ARDUINO_START + data + DELIMITER_JAVA_TO_ARDUINO_END);
    }

    // Getters & Setters
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

}
