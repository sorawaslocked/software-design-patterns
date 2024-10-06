package creational;

public class DriverManagerThreadSafe {
    private static volatile DriverManagerThreadSafe instance;

    private DriverManagerThreadSafe() {

    }

    public static DriverManagerThreadSafe getInstance() {
        if (instance == null) {
            synchronized (DriverManagerThreadSafe.class) {
                if (instance == null) {
                    instance = new DriverManagerThreadSafe();
                }
            }
        }

        return instance;
    }

    public String findNearestDriver(String location) {
        System.out.println("Nearest driver found: " + "Driver1");
        return "Driver1";
    }
}