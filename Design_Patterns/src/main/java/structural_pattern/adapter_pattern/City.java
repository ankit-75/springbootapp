package structural_pattern.adapter_pattern;

public interface City {
    String getName();
    double getTemp();
    String getTempScale();
    boolean getHasWeatherWarning();
    void setHasWeatherWarning(boolean hasWeatherWarning);


}
