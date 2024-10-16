package behavioral.commands;

import behavioral.Order;
import behavioral.OrderManager;

public abstract class Command {
    protected OrderManager orderManager;
    protected Order order;

    public Command(OrderManager orderManager, Order order) {
        this.orderManager = orderManager;
        this.order = order;
    }

    public abstract void execute();
}
