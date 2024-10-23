package behavioral2.strategy;

public class FixedPricingStrategy implements PricingStrategy {

    private static final double FIXED_PRICE = 2000;

    @Override
    public double computeCost() {
        return FIXED_PRICE;
    }
}
