package structural_pattern.flyweight_pattern;

public interface Vehicle {
    String getType();
    void setLocation(int lati, int longi);
    int[] getLocation();
}
