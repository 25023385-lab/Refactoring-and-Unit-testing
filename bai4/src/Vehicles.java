import java.util.ArrayList;
import java.util.List;
//long method
// Feature envy (ghen tị chức năng): class receipt gọi nhiều method của lớp khác hon nó
// switch/if-else phức tạp


class Vehicle {
    static final int CAR = 0;
    static final int BIKE = 1;
    static final int TRUCK = 2;

    private final String plate;
    private final int type;

    public Vehicle(String plate, int type) {
        this.plate = plate;
        this.type = type;
    }
    public String getPlate() { return plate; }
    public int getType() { return type; }
}

class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }
    public Vehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }
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
    public String receipt(){

    }
    public double calculateFee(tickets){
        double totalFee = 0;


    }
    public double calculateBonus(tickets){
        double totalBonus = 0;

    }
}
