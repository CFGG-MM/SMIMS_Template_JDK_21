package controller;

public abstract class AbstractController {

    /* Static Variables */

    /* Static Methods */

    /* Object Variables */

    /* Constructors */
    public AbstractController() {
       super();
    }

    /* Object Methods */
    protected abstract void werteDatenAus();

    public abstract void disconnect();

    /* Getters and Setters */
    /**
     * A getter for the x-axis of the joystick's analog stick.
     *
     * @return values ranging from <code>-512</code> (all the way left) to, <code>0</code> (neutral position) to
     * <code>511</code> (all the way right).
     */
    public abstract double getJoystickX();

    /**
     * A getter for the y-axis of the joystick's analog stick.
     *
     * @return values ranging from <code>-512</code> (all the way up) to, <code>0</code> (neutral position) to
     * <code>511</code> (all the way down).
     */
    public abstract double getJoystickY();

    public abstract boolean getA();

    public abstract boolean getB();

    // TODO: Mehr Methoden hinzufügen, z.B. für Buttons o.ä.

    /* Inner Classes */
}