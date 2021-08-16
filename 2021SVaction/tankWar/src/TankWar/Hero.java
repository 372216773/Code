package TankWar;

public class Hero extends Tank {
    public Hero(int x, int y, int speed) {
        super(x, y, speed);
        //this是当前对象的引用
        this.setDirection("up");
    }
}
