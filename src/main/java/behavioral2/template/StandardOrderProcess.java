package behavioral2.template;

import behavioral2.Driver;
import behavioral2.Order;
import behavioral2.OrderState;
import behavioral2.strategy.DistancePricingStrategy;

import java.util.List;

public class StandardOrderProcess extends OrderProcess {

    public StandardOrderProcess(List<Driver> availableDrivers, Order order) {
        super(availableDrivers, order);
    }

    @Override
    protected boolean confirmOrder() {
        boolean driverAvailable = checkAvailability();
        boolean balanceSufficient =
                checkClientBalance(new DistancePricingStrategy(order.getPickup(), order.getDestination()));

        if (driverAvailable && balanceSufficient) {
            order.getClient().setBalance(order.getClient().getBalance() - order.getCost());
            availableDrivers.remove(order.getDriver());
            order.setState(OrderState.ConfirmedState);

            return true;
        }

        return false;
    }
}
