package behavioral2;

public class Order {

    private static int idGen = 1;

    private int id;

    private OrderState state;

    private Location pickup;

    private Location destination;

    private Client client;

    private Driver driver;

    private double cost;

    private Order() {
        id = idGen++;
    }

    public Order(Location pickup, Location destination, Client client) {
        this();
        this.pickup = pickup;
        this.destination = destination;
        this.client = client;
        this.state = OrderState.CreatedState;
    }

    public int getId() {
        return id;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;

        client.update("Order #" + getId() + " state is: " + state.toString());
    }

    public Location getPickup() {
        return pickup;
    }

    public Location getDestination() {
        return destination;
    }

    public Client getClient() {
        return client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
