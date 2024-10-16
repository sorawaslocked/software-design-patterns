package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public abstract class Command {
    protected OrderManager orderManager;

    public Command(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public abstract void execute(Order order);
}
