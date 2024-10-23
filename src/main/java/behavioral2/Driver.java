package behavioral2;

public class Driver {

    private static final double MOVE_STEP = 300;

    private static int idGen = 1;

    private int id;

    private Location location;

    private Driver() {
        id = idGen++;
    }

    public Driver(Location location) {
        this();
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void moveTowards(Location destination) {

        double distance = Location.getDistanceBetween(location, destination);

        if (distance <= MOVE_STEP) {
            location.setX(destination.getX());
            location.setY(destination.getY());
        } else {
            if (location.getX() < destination.getX()) {
                location.setX(location.getX() + MOVE_STEP);
            } else if (location.getX() > destination.getX()) {
                location.setX(location.getX() - MOVE_STEP);
            }

            if (location.getY() < destination.getY()) {
                location.setY(location.getY() + MOVE_STEP);
            } else if (location.getY() > destination.getY()) {
                location.setY(location.getY() - MOVE_STEP);
            }
        }
    }
}
