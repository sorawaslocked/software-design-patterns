package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public class CancelOrderCommand extends Command {
    public CancelOrderCommand(OrderManager orderManager) {
        super(orderManager);
    }

    @Override
    public void execute(Order order) {
        orderManager.cancelOrder(order);
    }
}
