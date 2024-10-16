package behavioral;

public class Driver {
    private DispatchMediator mediator;
    private double distanceToClient;

    public Driver(double distanceToClient) {
        this.distanceToClient = distanceToClient;
    }

    public Driver(DispatchMediator mediator, double distanceToClient) {
        this.mediator = mediator;
        this.distanceToClient = distanceToClient;
    }

    public void notifyAvailability() {
        mediator.notifyAvailability(this);
    }

    public double getDistanceToClient() {
        return distanceToClient;
    }
}
