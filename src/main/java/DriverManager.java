public class DriverManager {
    private static DriverManager instance = null;

    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }

        return instance;
    }

    public String findNearestDriver(String location) {
        System.out.println("Nearest driver found: " + "Driver1");
        return "Driver1";
    }
}