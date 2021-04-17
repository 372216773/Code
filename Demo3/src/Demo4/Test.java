package Demo4;

public class Test {

    public static void main(String[] args) {

        Vehicle vehicle=new Vehicle();
        vehicle.speed=0;
        vehicle.size=167;
        vehicle.time=0;
        vehicle.getVehicleSize();
        vehicle.getVehicleInformation();
        vehicle.setSpeed(23);
        vehicle.speedUp(4);
        vehicle.speedDown(7);
        vehicle.move(5);
        vehicle.getVehicleInformation();

    }

}
