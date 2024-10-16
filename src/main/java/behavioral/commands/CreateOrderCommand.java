package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public class CreateOrderCommand extends Command {
    public CreateOrderCommand(OrderManager orderManager) {
        super(orderManager);
    }

    @Override
    public void execute(Order order) {
        orderManager.createOrder(order);
    }
}
