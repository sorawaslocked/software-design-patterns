package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public class CancelOrderCommand extends Command {
    public CancelOrderCommand(OrderManager orderManager, Order order) {
        super(orderManager, order);
    }

    @Override
    public void execute() {
        orderManager.cancelOrder(order);
    }
}
