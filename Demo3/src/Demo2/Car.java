package Demo2;

public class Car extends Vehicle{

    public Car(){
        System.out.println("Car的无参构造器");
        this.height=1;
        this.power="人力";
        this.wheels=2;
        this.width=1.2;

    }

    public String NoOfWheels(){
        return "这是一辆"+wheels+"轮车:"+"\n高:"+height+"\t宽:"+width+"\t动力:"+power;
    }
}
