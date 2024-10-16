package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public class CreateOrderCommand extends Command {
    public CreateOrderCommand(OrderManager orderManager, Order order) {
        super(orderManager, order);
    }

    @Override
    public void execute() {
        orderManager.createOrder(order);
    }
}
