import behavioral.*;

public class Main {
    public static void main(String[] args) {
        testChainOfResponsibility();
    }

    public static void testChainOfResponsibility() {
        TaxiDispatch taxiDispatch = new TaxiDispatch();

        Client client0 = new Client(2000, new Location("1st Street"));

        // Process without available cars
        System.out.println(taxiDispatch.processRequest(client0));

        taxiDispatch.initializeData();

        // Process with valid conditions
        Client client1 = new Client(1050, new Location("1st Street"));
        // Process with lower client balance
        Client client2 = new Client(1000, new Location("2nd Street"));
        // Process with invalid location
        Client client3 = new Client(2000, new Location("4th Street"));

        System.out.println(taxiDispatch.processRequest(client1));
        System.out.println(taxiDispatch.processRequest(client2));
        System.out.println(taxiDispatch.processRequest(client3));
    }
}
