package TankWar;

public class Enemy extends Tank{
    public Enemy(int x, int y, int speed) {
        super(x, y, speed);
        this.setDirection("down");
    }
}
