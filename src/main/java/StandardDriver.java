public class StandardDriver extends Driver3 {
    public StandardDriver(String driverName) {
        super(driverName);
    }

    @Override
    public void drive() {
        System.out.println("Driver regularly");
    }
}