package structural;

public class CarSharing {
    public Car car;

    public CarSharing(Car car) {
        this.car = car;
    }

    public void rentFreeCar(Driver driver) {
        driver.addCar(car);
    }
}
