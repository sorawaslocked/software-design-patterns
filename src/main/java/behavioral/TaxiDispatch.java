package behavioral;

import behavioral.handlers.*;

import java.util.HashSet;
import java.util.Set;

public class TaxiDispatch {
    private Set<Car> availableCars;
    private Set<Location> availableLocations;

    public TaxiDispatch() {
        availableCars = new HashSet<>();
        availableLocations = new HashSet<>();
    }

    public boolean processRequest(Client client) {
        // I changed the order in the chain, because I thought that checking
        // if a location is valid before balance made more sense to me
        Handler handler = Handler.link(
                new CarAvailabilityHandler(availableCars),
                new LocationAssessmentHandler(availableLocations, client.getLocation()),
                new ClientBalanceHandler(client.getBalance(), computeRideCost(client.getLocation()))
        );

        return handler.handle();
    }

    private double computeRideCost(Location clientLocation) {
        // Let's pretend that a sophisticated algorithm that computes the ride cost
        // based on a client location is here instead2
        return 1050;
    }

    // Set initial values for locations and cars
    public void initializeData() {
        availableCars.add(new Car());
        availableCars.add(new Car());
        availableCars.add(new Car());

        availableLocations.add(new Location("1st Street"));
        availableLocations.add(new Location("2nd Street"));
        availableLocations.add(new Location("3rd Street"));
    }
}
