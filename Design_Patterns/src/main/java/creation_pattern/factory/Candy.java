package creation_pattern.factory;

import java.util.ArrayList;

public abstract class Candy {
    abstract ArrayList<Candy> makeCandyPackage(int quantity);
}
