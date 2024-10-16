package behavioral.handlers;

public class ClientBalanceHandler extends Handler {
    private double clientBalance;
    private double rideCost;

    public ClientBalanceHandler(double clientBalance, double rideCost) {
        this.clientBalance = clientBalance;
        this.rideCost = rideCost;
    }

    @Override
    public boolean handle() {
        if (clientBalance < rideCost) {
            return false;
        }

        return handleNext();
    }
}
