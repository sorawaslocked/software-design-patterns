package behavioral;

public class Location {
    private String street;

    public Location(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public int hashCode() {
        return street.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Location other = (Location) obj;

        return street.equals(other.getStreet());
    }
}
