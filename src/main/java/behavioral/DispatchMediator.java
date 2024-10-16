package behavioral;

import java.util.List;

public class DispatchMediator {
    private DriverIterator availableDrivers;

    public DispatchMediator(List<Driver> availableDrivers) {
        this.availableDrivers = new DriverIterator(availableDrivers);
    }

    public void requestTaxi(Client client) {
        // Let's pretend that the client was processed and the driver is assigned
        System.out.println("Client with hashcode " + client.hashCode() + " was processed");
        availableDrivers.findClosest();
    }

    public void notifyAvailability(Driver driver) {
        availableDrivers.addDriver(driver);
    }
}