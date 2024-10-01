public class Main {
    public static void main(String[] args) {
        Factory factory = new StandardTaxiFactory();
        Driver3 driver = factory.createDriver("Daniele");
        Taxi taxi = factory.createTaxi("Daniele", "XYZ12345");
        driver.drive();
        taxi.takePassenger("Sam");

        factory = new PremiumTaxiFactory();
        driver = factory.createDriver("Daniele");
        taxi = factory.createTaxi("Daniele", "XYZ12345");
        driver.drive();
        taxi.takePassenger("Max");
    }
}
