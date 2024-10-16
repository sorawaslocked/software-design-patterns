import behavioral.*;
import behavioral.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testChainOfResponsibility();
        testCommand();
    }

    public static void testChainOfResponsibility() {
        System.out.println("***** CHAIN OF RESPONSIBILITY *****");
        TaxiDispatch taxiDispatch = new TaxiDispatch();

        Client client0 = new Client(2000, new Location("1st Street"));

        // Process without available cars
        System.out.println(taxiDispatch.processRequest(client0));

        taxiDispatch.initializeData();

        // Process with valid conditions
        Client client1 = new Client(1050, new Location("1st Street"));
        // Process with lower client balance
        Client client2 = new Client(1000, new Location("2nd Street"));
        // Process with invalid location
        Client client3 = new Client(2000, new Location("4th Street"));

        System.out.println(taxiDispatch.processRequest(client1));
        System.out.println(taxiDispatch.processRequest(client2));
        System.out.println(taxiDispatch.processRequest(client3));

        System.out.println();
    }

    public static void testCommand() {
        System.out.println("***** COMMAND *****");

        OrderManager manager = new OrderManager();

        Order order1 = new Order(1, "Destination A");
        Order order2 = new Order(2, "Destination B");
        Order order3 = new Order(3, "Destination C");

        List<Command> createCommands = new ArrayList<>();

        createCommands.add(new CreateOrderCommand(manager, order1));
        createCommands.add(new CreateOrderCommand(manager, order2));
        createCommands.add(new CreateOrderCommand(manager, order3));

        for (Command c : createCommands) {
            c.execute();
        }

        System.out.println("BEFORE");
        manager.showAllOrders();

        List<Command> cancelAndChangeDestinationCommands = new ArrayList<>();

        cancelAndChangeDestinationCommands.add(new CancelOrderCommand(manager, order1));
        cancelAndChangeDestinationCommands.add(new CancelOrderCommand(manager, order2));
        cancelAndChangeDestinationCommands.add(
                new ChangeDestinationCommand(manager, order3, "Destination A"));

        System.out.println("AFTER");
        for (Command c : cancelAndChangeDestinationCommands) {
            c.execute();
        }

        manager.showAllOrders();
    }
}
