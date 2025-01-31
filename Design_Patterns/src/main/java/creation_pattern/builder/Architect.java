package creation_pattern.builder;

import java.awt.*;

public class Architect {
    Bedroom bedroom = new BedroomBuilder().setDimension(new Dimension(200, 200)).setCeilingHeight(100).setFloorNumber(120).setColor(Color.BLUE).createBedroom();
}
