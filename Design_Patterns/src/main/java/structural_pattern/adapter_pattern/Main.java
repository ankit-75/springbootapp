package structural_pattern.adapter_pattern;

public class Main {
    public static void main(String[] args) {
        WeatherWarnings weatherWarnings = new WeatherWarnings();
        NorthAmericaCity chicago = new NorthAmericaCity("Chicago", 16);
        weatherWarnings.postWarning(chicago);

        NorthAmericaCity phonix = new NorthAmericaCity("phonix", 104);
        weatherWarnings.postWarning(phonix);

        AsianCity bankok = new AsianCity("Bankok", 50);
        weatherWarnings.postWarning(bankok);

        Adapter adapter = new Adapter(bankok);
        weatherWarnings.postWarning(adapter);
    }
}
