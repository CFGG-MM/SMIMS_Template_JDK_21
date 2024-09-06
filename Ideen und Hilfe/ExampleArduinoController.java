package controller;

import jssc.SerialPortException;

public class ExampleArduinoController extends AbstractController {

    /* Static Variables */
    private static final String DELIMITER_ARDUINO_TO_JAVA_START = "#";
    private static final String DELIMITER_ARDUINO_TO_JAVA_END = "?";

    /* Static Methods */

    /* Object Variables */
    // TODO: Add variables for every element of the game controller.

    /* Constructors */

    /* Object Methods */
    @Override
    protected void werteDatenAus() {

        // Try to find the delimiters in the data we got from the Arduino.
        int start = data.indexOf(DELIMITER_ARDUINO_TO_JAVA_START);
        int end = data.indexOf(DELIMITER_ARDUINO_TO_JAVA_END);

        // Are both delimiters present in the string?
        if (start < 0 || end < 0) {
            return;
        }

        // So we have both delimiters in the string but they might not be in the right order because the end of a line
        // might be 'dangling' into the next one.
        if (end <= start) {

            // In this case, we can cut off the false data at the front.
            data = data.substring(end + 1);
            return;

        }

        // Shorten the string so that we only have the 'payload data'.
        data = data.substring(start + 1, end);

        // TODO: Set all the variables.

        // Empty the data string to be ready for the next input.
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

    /* Inner Classes */

}
