package behavioral2.template;

import behavioral2.Driver;
import behavioral2.Order;
import behavioral2.OrderState;

import java.util.List;

public class StandardOrderProcess extends OrderProcess {

    public StandardOrderProcess(List<Driver> availableDrivers, Order order) {
        super(availableDrivers, order);
    }

    @Override
    public void processOrder() {
        if (order.getState() == OrderState.FinishedState) {
            return;
        }

        if (confirmOrder()) {
            dispatchTaxiToPassenger();
            driveTaxiToDestination();
        }
    }
}
