import structural.*;

public class Main {
    public static void main(String[] args) {
        Passenger passenger = new Passenger();
        TaxiService taxiService = new CarSharingAdapter();
        taxiService.requestTaxi(passenger);
    }
}
