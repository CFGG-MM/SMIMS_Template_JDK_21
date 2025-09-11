package common;

import sas.Picture;

import java.awt.image.BufferedImage;

/**
 * <p>Eine Hilfsklasse, die dabei helfen soll, Bilder (also {@link Picture}-Objekte) vernünftig zu skalieren. Das ist
 * nämlich manchmal ein wenig nervig. Ich schlage folgende Verwendung vor:</p>
 * <ul>
 *     <li>Objekt erstellen (ggf. auch ohne die Angabe von width / height</li>
 *     <li>{@link #scaleTo(double)} verwenden</li>
 *     <li>mit {@link #moveTo(double, double)} an die richtige Position bewegen</li>
 * </ul>
 */
public class ScalablePicture extends Picture {

    // Static Variables

    // Static Methods and Functions

    // Object Variables

    // Constructors
    public ScalablePicture(double xp, double yp, String name) {
        super(xp, yp, name);
    }

    public ScalablePicture(double xp, double yp, double w, double h, String name) {
        super(xp, yp, w, h, name);
    }

    protected ScalablePicture(double xp, double yp, BufferedImage image) {
        super(xp, yp, image);
    }

    // Methods and Functions
    public void scaleTo(double height) {
        scaleTo((height * getWidth()) / getHeight(), height);
    }

    // Getters & Setters

    // Inner Classes

}