package behavioral2.template;

import behavioral2.Driver;
import behavioral2.Order;
import behavioral2.OrderState;
import behavioral2.strategy.FixedPricingStrategy;

import java.util.List;

public class SubscriptionOrderProcess extends OrderProcess {

    public SubscriptionOrderProcess(List<Driver> availableDrivers, Order order) {
        super(availableDrivers, order);
    }

    @Override
    protected boolean confirmOrder() {

        boolean sufficientBalance = checkClientBalance(new FixedPricingStrategy());
        boolean checkAvailability = checkAvailability();
        boolean clientSubscribed = checkClientSubscription();

        if (sufficientBalance && checkAvailability && clientSubscribed) {
            order.getClient().setBalance(order.getClient().getBalance() - order.getCost());
            availableDrivers.remove(order.getDriver());
            order.setState(OrderState.ConfirmedState);

            return true;
        }

        return false;
    }

    private boolean checkClientSubscription() {
        // all clients are subscribed i guess

        return true;
    }
}
