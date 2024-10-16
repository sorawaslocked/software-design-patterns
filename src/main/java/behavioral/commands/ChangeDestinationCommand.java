package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public class ChangeDestinationCommand extends Command {
    private String newDestination;

    public ChangeDestinationCommand(OrderManager orderManager, Order order, String newDestination) {
        super(orderManager, order);
        this.newDestination = newDestination;
    }

    @Override
    public void execute() {
        orderManager.changeDestination(order, newDestination);
    }
}
