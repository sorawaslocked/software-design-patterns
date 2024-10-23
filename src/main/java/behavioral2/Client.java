package behavioral2;

public class Client {

    private static int idGen = 1;

    private int id;

    private double balance;

    private Client() {
        id = idGen++;
    }

    public Client(double balance) {
        this();
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void update(String event) {
        System.out.println(event);
    }
}
