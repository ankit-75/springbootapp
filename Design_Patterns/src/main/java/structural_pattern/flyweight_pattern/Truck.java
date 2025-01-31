package structural_pattern.flyweight_pattern;

public class Truck implements Vehicle {
    private int[] location = new int[2];

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public void setLocation(int lati, int longi) {
        location[0] = lati;
        location[1] = longi;
    }

    @Override
    public int[] getLocation() {
        return location;
    }
}
