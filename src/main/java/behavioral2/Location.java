package behavioral2;

public class Location {

    private double x;

    private double y;

    public Location() {
        this.x = 0;
        this.y = 0;
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(x, location.x) == 0 && Double.compare(y, location.y) == 0;
    }

    public static double getDistanceBetween(Location source, Location destination) {
        double diffX = source.getX() - destination.getX();
        double diffY = source.getY() - destination.getY();

        return Math.sqrt(diffX * diffX + diffY * diffY);
    }
}
