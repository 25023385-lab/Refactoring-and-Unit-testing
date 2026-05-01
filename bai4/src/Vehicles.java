
import java.util.ArrayList;
import java.util.List;

abstract public class Vehicle {
    static final int CAR = 0;
    static final int BIKE = 1;
    static final int TRUCK = 2;

    private final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }
    public String getPlate() { return plate; }
    abstract public double getFee(int hours);
    abstract public int getBonus(int hours);
}

class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getHours() {
        return hours;
    }

    public double getFee() {
        return vehicle.getFee(this.hours);
    }


    public double getBonus() {
       return vehicle.getBonus(this.hours);
    }

    class ParkingCustomer {
        private final String name;
        private final List<ParkingTicket> tickets = new ArrayList<>();

        public ParkingCustomer(String name) {
            this.name = name;
        }

        public void addTicket(ParkingTicket ticket) {
            tickets.add(ticket);
        }

        public String receipt() {
            double totalFee = 0;
            int totalBonus = 0;
            String result = "Parking Receipt for " + name + "\n";

            for (ParkingTicket each : tickets) {
                // Tích lũy tiền và điểm
                totalFee += each.getFee();
                totalBonus += each.getBonus();

            result += "Total fee is " + totalFee + "\n";
            result += "You earned " + totalBonus + " bonus points";
        }
            return result;
        }
    }

class Car extends Vehicle {
    public Car(String plate){
        super(plate);
    }
    @Override
    public double getFee(int hours) {
        double fee = 10;
        if (hours > 2) fee += (hours - 2) * 3;
        return fee;
    }
    @Override
    public int getBonus(int hours) { return 1; }
}

class Bike extends Vehicle{
    public Bike(String plate){
        super(plate);
    }

    @Override
    public double getFee(int hours) {
        double fee = 5;
        if (hours > 3){
            fee = (hours - 3)*2;
        }
        return fee;
    }
    @Override
    public int getBonus(int hours) { return 1; } // Xe đạp mặc định 1 điểm
}
class Truck extends Vehicle {
    public Truck(String plate) {
        super(plate);
    }

    @Override
    public double getFee(int hours) {
        double fee = 15 + hours * 4;
        return fee;
    }

    @Override
    public int getBonus(int hours) {
        // Xe tải gửi trên 5h được 2 điểm, còn lại 1 điểm
        return (hours > 5) ? 2 : 1;
    }
    }
}
