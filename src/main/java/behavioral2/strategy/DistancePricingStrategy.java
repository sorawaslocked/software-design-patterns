package behavioral2.strategy;

import behavioral2.Location;

public class DistancePricingStrategy implements PricingStrategy {

    private static final double DISTANCE_MULTIPLIER = 0.8;

    private Location pickup;

    private Location destination;

    public DistancePricingStrategy(Location pickup, Location destination) {
        this.pickup = pickup;
        this.destination = destination;
    }

    @Override
    public double computeCost() {

        return Location.getDistanceBetween(pickup, destination) * DISTANCE_MULTIPLIER;
    }
}
