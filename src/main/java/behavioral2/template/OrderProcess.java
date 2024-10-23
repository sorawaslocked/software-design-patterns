package behavioral2.template;

import behavioral2.Driver;
import behavioral2.Location;
import behavioral2.Order;
import behavioral2.OrderState;
import behavioral2.strategy.DistancePricingStrategy;
import behavioral2.strategy.PricingStrategy;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class OrderProcess {

    protected static final ScheduledExecutorService scheduler1 = Executors.newScheduledThreadPool(1);
    protected static final ScheduledExecutorService scheduler2 = Executors.newScheduledThreadPool(1);
    protected static final CountDownLatch countDownLatch = new CountDownLatch(1);

    protected static final double MAX_DISTANCE_METERS = 3000;

    protected static final double MIN_DISTANCE_FOR_ARRIVAL = 600;

    protected final List<Driver> availableDrivers;

    protected final Order order;

    public OrderProcess(List<Driver> availableDrivers, Order order) {
        this.availableDrivers = availableDrivers;
        this.order = order;
    }

    protected boolean checkAvailability() {

        for (Driver driver : availableDrivers) {
            double distance = Location.getDistanceBetween(driver.getLocation(), order.getPickup());

            if (distance <= MAX_DISTANCE_METERS) {
                order.setDriver(driver);
                availableDrivers.removeIf(d -> d.getId() == driver.getId());

                return true;
            }
        }

        return false;
    }

    protected double computeCost() {
        PricingStrategy strategy = new DistancePricingStrategy(order.getPickup(), order.getDestination());

        double cost = strategy.computeCost();

        order.setCost(cost);

        return cost;
    }

    protected boolean checkClientBalance() {

        double cost = computeCost();

        if (cost <= order.getClient().getBalance()) {
            order.getClient().setBalance(order.getClient().getBalance() - cost);
            return true;
        }

        return false;
    }

    protected boolean confirmOrder() {

        boolean driverAvailable = checkAvailability();
        boolean sufficientBalance = checkClientBalance();

        if (driverAvailable && sufficientBalance) {
            order.setState(OrderState.ConfirmedState);

            return true;
        } else {
            availableDrivers.add(order.getDriver());
            order.getClient().setBalance(order.getClient().getBalance() + computeCost());
            order.setState(OrderState.FinishedState);

            return false;
        }
    }

    protected void dispatchTaxiToPassenger() {
        order.setState(OrderState.EnRouteState);
        Driver driver = order.getDriver();

        Runnable moveTask = new Runnable() {
            @Override
            public void run() {
                driver.moveTowards(order.getPickup());

                double distanceToPickup = Location.getDistanceBetween(driver.getLocation(), order.getPickup());

                System.out.println(order.getId() + " " + distanceToPickup);

                if (distanceToPickup <= MIN_DISTANCE_FOR_ARRIVAL) {
                    order.setState(OrderState.ArrivingState);
                }

                if (distanceToPickup == 0) {
                    order.setState(OrderState.DrivingPassengerState);
                    countDownLatch.countDown();
                    scheduler1.shutdownNow();
                }
            }
        };

        scheduler1.scheduleAtFixedRate(moveTask, 0, 1, TimeUnit.SECONDS);
    }

    protected void driveTaxiToDestination() {
        Driver driver = order.getDriver();

        Runnable moveTask = new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    driver.moveTowards(order.getDestination());

                    double distanceToDestination = Location.getDistanceBetween(driver.getLocation(), order.getDestination());
                    System.out.println(order.getId() + " " + distanceToDestination);

                    if (distanceToDestination == 0) {
                        order.setState(OrderState.FinishedState);
                        scheduler2.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        scheduler2.scheduleAtFixedRate(moveTask, 0, 1, TimeUnit.SECONDS);
    }

    public abstract void processOrder();
}
