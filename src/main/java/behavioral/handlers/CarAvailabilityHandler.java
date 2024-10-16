package behavioral.handlers;

import behavioral.Car;

import java.util.Set;

public class CarAvailabilityHandler extends Handler {
    private Set<Car> availableCars;

    public CarAvailabilityHandler(Set<Car> availableCars) {
        this.availableCars = availableCars;
    }

    @Override
    public boolean handle() {
        if (availableCars.isEmpty()) {
            return false;
        }

        return handleNext();
    }
}
