//vì lớp cha co thuoc tinh ma khong dung cho lop con
// push các thuộc tính thành các lớp con
//get in4 bị viết đi viết lại trong subclass nen neu phải sửa thì phải sửa eachsubclass
abstract public class Vehicle {
    protected String plate;
    protected String brand;
    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }
    void getInfo(){
        System.out.println(getVehicleType() + " [" + plate + "] - " + brand);
    }

    abstract public String getVehicleType();
}
abstract class FuelCar extends Vehicle {
    protected double fuelLevel;
    public FuelCar(String plate, String brand ,double fuelLevel){
        super(plate,brand);
        this.fuelLevel = fuelLevel;
    }
    public void refuel(double liters) {
        this.fuelLevel += liters;
    }
}
class MotorBike extends FuelCar {
    public MotorBike(String plate, String brand, double fuelLevel) {
        super(plate, brand, fuelLevel);
    }
    @Override
    public String getVehicleType() {
        return "Motor Bike";
    }
}
class Car extends FuelCar {
    public Car(String plate, String brand, double fuelLevel) {
        super(plate, brand, fuelLevel);
    }
    @Override
    public String getVehicleType() {
        return "Car";
    }
}
class ElectricCar extends Vehicle{
    protected int batteryPercent;
    public ElectricCar(String plate, String brand, int batteryPercent) {
        super(plate,brand);
        this.batteryPercent = batteryPercent;
    }
    @Override
    public String getVehicleType() {
        return "Electric";
    }
    public void charge(int percent) {
        this.batteryPercent += percent;
    }
}
class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new MotorBike("29-A1 123.45", "Honda",50);
        vehicles[1] = new Car("30-F 999.99", "Toyota",30);
        vehicles[2] = new ElectricCar("51-E 888.88", "VinFast",30);
        for (Vehicle v : vehicles) {
            v.getInfo();
        }
    }
}