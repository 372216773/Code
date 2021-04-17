package Demo2;

public class Motorbike extends Vehicle{

    public Motorbike(){
        System.out.println("Motorbike的无参构造器");
        this.height=2.4;
        this.power="柴油";
        this.wheels=4;
        this.width=6;

    }

    public String NoOfWheels(){
        return "这是一辆"+this.wheels+"轮车:"+"\n高:"+height+"\t宽:"+width+"\t动力:"+power;
    }
}
