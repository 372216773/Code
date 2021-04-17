package Rectangle;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle(){

    }

    public Rectangle(int width,int height){
        this.width=width;
        this.height=height;
    }

    public void Change(int width,int height){
        this.width=width;
        this.height=height;
    }

    public void ShowInformation(){
        System.out.println("width:"+width+"\theight:"+height);
    }

    public void area(){
        System.out.println("area:"+width*height);
    }

}
