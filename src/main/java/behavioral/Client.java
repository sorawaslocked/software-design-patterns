package behavioral;

public class Client {
    private double balance;
    private Location location;

    public Client(double balance, Location location) {
        this.balance = balance;
        this.location = location;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
