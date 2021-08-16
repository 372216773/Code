package TankWar;

public class Hero extends Tank {

    Shoot shoot;

    public Hero(int x, int y, int speed) {
        super(x, y, speed);
        //this是当前对象的引用
        this.setDirection("up");
    }

    public void shooting() {
        //根据当前坦克位置方向创建子弹
        switch (this.getDirection()) {
            case "up":
                shoot = new Shoot(getX() + 20, getY(), this.getDirection());
                break;
            case "down":
                shoot = new Shoot(getX() + 20, getY() + 60, this.getDirection());
                break;
            case "left":
                shoot = new Shoot(getX(), getY() + 20, this.getDirection());
                break;
            case "right":
                shoot = new Shoot(getX() + 60, getY() + 20, this.getDirection());
                break;
        }
        Thread thread = new Thread(shoot);
        thread.start();
    }
}
