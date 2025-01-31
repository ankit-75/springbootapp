package structural_pattern.adapter_pattern;

public class NorthAmericaCity implements City {
    private String name;
    private double temp;
    private boolean hasWeatherWarning;

    public NorthAmericaCity(String name, double temp) {
        this.name = name;
        this.temp = temp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTemp() {
        return temp;
    }

    @Override
    public String getTempScale() {
        return "Fahrenheit";
    }

    @Override
    public boolean getHasWeatherWarning() {
        return hasWeatherWarning;
    }

    @Override
    public void setHasWeatherWarning(boolean hasWeatherWarning) {
        this.hasWeatherWarning = hasWeatherWarning;
    }
}
