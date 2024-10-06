package creational;

public class PremiumTaxiFactory extends Factory {
    @Override
    public Taxi createTaxi(String driverName, String license) {
        return new PremiumTaxi(driverName, license);
    }

    @Override
    public Driver3 createDriver(String driverName) {
        return new PremiumDriver(driverName);
    }
}
