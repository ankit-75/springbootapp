package creation_pattern.builder;

import java.awt.*;

public class BedroomBuilder {
    private Dimension dimension;
    private int ceilingHeight;
    private int floorNumber;
    private Color color;

    public BedroomBuilder setDimension(Dimension dimension) {
        this.dimension = dimension;
        return this;
    }

    public BedroomBuilder setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
        return this;
    }

    public BedroomBuilder setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    public BedroomBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public Bedroom createBedroom() {
        return new Bedroom(dimension, ceilingHeight, floorNumber, color);
    }
}