package Demo4;

public class Vehicle {

    public double speed;
    public double size;
    public double time;

    public void move(double time){
        this.time=time;
        System.out.println("distance:"+this.time*speed+"m");
    }

    public void setSpeed(double speed){
        this.speed=speed;
        System.out.println("NOW:speed   "+this.speed+"m/s");
    }

    public void speedUp(double speed){
        this.speed+=speed;
        System.out.println("NOW:speed   "+this.speed+"m/s");
    }

    public void speedDown(double speed){
        this.speed-=speed;
        System.out.println("NOW:speed   "+this.speed+"m/s");
    }

    public void getVehicleInformation(){
        System.out.println("NOW: speed:"+speed+"m/s\t time:"+time+"s");
    }

    public void getVehicleSize(){
        System.out.println("VehicleSizeInformation:"+size);
    }

}
