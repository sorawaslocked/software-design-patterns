package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public class ChangeDestinationCommand extends Command {
    private String newDestination;

    public ChangeDestinationCommand(OrderManager orderManager, String newDestination) {
        super(orderManager);
        this.newDestination = newDestination;
    }

    @Override
    public void execute(Order order) {
        orderManager.changeDestination(order, newDestination);
    }
}
