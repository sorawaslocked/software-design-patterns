package behavioral;

import java.util.*;

public class DriverIterator implements Iterator<Driver> {
    private List<Driver> drivers;
    private int currentIndex = 0;

    public DriverIterator(List<Driver> drivers) {
        this.drivers = new ArrayList<>(drivers);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < drivers.size();
    }

    @Override
    public Driver next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return drivers.get(currentIndex++);
    }

    public Driver findClosest() {
        double minDistance = Double.MAX_VALUE;
        Driver closestDriver = null;

        while (hasNext()) {
            Driver driver = next();

            if (driver.getDistanceToClient() < minDistance) {
                minDistance = driver.getDistanceToClient();
                closestDriver = driver;
            }
        }

        return closestDriver;
    }
}
