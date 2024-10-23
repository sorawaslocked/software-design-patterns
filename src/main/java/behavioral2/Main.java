package behavioral2;

import behavioral2.template.OrderProcess;
import behavioral2.template.StandardOrderProcess;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Driver> drivers = new ArrayList<>();

        drivers.add(new Driver(new Location(-3000, -2500)));
        drivers.add(new Driver(new Location(2000, 1200)));
        drivers.add(new Driver(new Location(5000, 7000)));
        drivers.add(new Driver(new Location(1000, 1000)));

        Client poorClient = new Client(200);
        Client richClient = new Client(50000);

        Order order1 = new Order(new Location(300, 300), new Location(2500, 2500), poorClient);
        Order order2 = new Order(new Location(300, 300), new Location(5000, 5000), richClient);

        OrderProcess standardOrderProcess1 = new StandardOrderProcess(drivers, order1);
        OrderProcess standardOrderProcess2 = new StandardOrderProcess(drivers, order2);

        standardOrderProcess1.processOrder();
        standardOrderProcess2.processOrder();
    }
}
