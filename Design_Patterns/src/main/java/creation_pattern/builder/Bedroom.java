package creation_pattern.builder;

import java.awt.*;

public class Bedroom {
    private Dimension dimension;
    private int ceilingHeight;
    private int floorNumber;
    private Color color;

    public Bedroom(Dimension dimension, int ceilingHeight, int floorNumber, Color color) {
        this.dimension = dimension;
        this.ceilingHeight = ceilingHeight;
        this.floorNumber = floorNumber;
        this.color = color;
    }
}
