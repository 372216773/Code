package TankWar;

public class Tank {
    private int x;
    private int y;
    private String direction;
    private int speed = 1;

    public String getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void MoveLeft() {
        this.x-=this.speed;
    }
    public void MoveRight() {
        this.x+=this.speed;
    }
    public void MoveUp() {
        this.y-=this.speed;
    }
    public void MoveDown() {
        this.y+=this.speed;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Tank(int x, int y,int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
