package behavioral;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void createOrder(Order order) {
        orders.add(order);
    }

    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    public void changeDestination(Order order, String newDestination) {
        for (Order o : orders) {
            if (order.getId() == o.getId()) {
                o.setDestination(newDestination);
            }
        }
    }
}
