package behavioral2.template;

import behavioral2.Driver;
import behavioral2.Order;
import behavioral2.OrderState;
import behavioral2.strategy.DistancePricingStrategy;
import behavioral2.strategy.TimePricingStrategy;

import java.util.List;

public class TimeOrderProcess extends OrderProcess {
    public TimeOrderProcess(List<Driver> availableDrivers, Order order) {
        super(availableDrivers, order);
    }

    @Override
    protected boolean confirmOrder() {
        final double APPROXIMATE_TIME_MINUTES = 30;

        boolean driverAvailable = checkAvailability();
        boolean balanceSufficient =
                checkClientBalance(new TimePricingStrategy(APPROXIMATE_TIME_MINUTES));

        if (driverAvailable && balanceSufficient) {
            availableDrivers.remove(order.getDriver());
            order.setState(OrderState.ConfirmedState);

            return true;
        }

        return false;
    }

    @Override
    public void processOrder() {
        super.processOrder();

        double actualCost = new TimePricingStrategy(getActualTimeInMinutes()).computeCost();

        order.setCost(actualCost);
        order.getClient().setBalance(order.getClient().getBalance() - actualCost);
    }

    private double getActualTimeInMinutes() {
        return 200;
    }
}
