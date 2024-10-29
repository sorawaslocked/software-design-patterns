package behavioral2.strategy;

public class TimePricingStrategy implements PricingStrategy {
    private static final double TIME_PRICE_FACTOR = 1.4;

    private final double timeInMinutes;

    public TimePricingStrategy(double timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    @Override
    public double computeCost() {
        return timeInMinutes * TIME_PRICE_FACTOR;
    }
}
