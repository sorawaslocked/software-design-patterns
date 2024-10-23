package behavioral2;

public enum OrderState {

    CreatedState("created"),
    ConfirmedState("confirmed"),
    EnRouteState("en route"),
    ArrivingState("arriving"),
    DrivingPassengerState("driving passenger"),
    FinishedState("finished");

    private final String description;

    OrderState(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
