package structural_pattern.adapter_pattern;

public class Adapter implements City{
    City city;

    public Adapter(City city) {
        this.city = city;
    }

    @Override
    public String getName() {
        return city.getName();
    }

    @Override
    public double getTemp() {

        return city.getTemp()*1.8 + 32;
    }

    @Override
    public String getTempScale() {
        return "Fahrenheit";
    }

    @Override
    public boolean getHasWeatherWarning() {
        return city.getHasWeatherWarning();
    }

    @Override
    public void setHasWeatherWarning(boolean hasWeatherWarning) {
        city.setHasWeatherWarning(hasWeatherWarning);
    }

}
