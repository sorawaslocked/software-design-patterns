public class StandardTaxiFactory extends Factory {
    @Override
    public Taxi createTaxi(String driverName, String license) {
        return new StandardTaxi(driverName, license);
    }

    @Override
    public Driver3 createDriver(String driverName) {
        return new StandardDriver(driverName);
    }
}
