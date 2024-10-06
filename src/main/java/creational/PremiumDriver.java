package creational;

public class PremiumDriver extends Driver3 {
    public PremiumDriver(String driverName) {
        super(driverName);
    }

    @Override
    public void drive() {
        System.out.println("creationalpatterns.Driver with comfort");
    }
}