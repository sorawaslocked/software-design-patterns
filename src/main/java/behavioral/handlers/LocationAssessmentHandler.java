package behavioral.handlers;

import behavioral.Location;

import java.util.Set;

public class LocationAssessmentHandler extends Handler {
    private Set<Location> validLocations;
    private Location clientLocation;

    public LocationAssessmentHandler(Set<Location> validLocations, Location clientLocation) {
        this.validLocations = validLocations;
        this.clientLocation = clientLocation;
    }

    @Override
    public boolean handle() {
        if (!validLocations.contains(clientLocation)) {
            return false;
        }

        return handleNext();
    }
}
