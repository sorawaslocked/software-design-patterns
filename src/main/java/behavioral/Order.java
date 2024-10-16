package behavioral;

public class Order {
    private int id;
    private String destination;

    public Order(int id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                '}';
    }
}
