package TankWar;

public class Shoot implements Runnable {
    //子弹初始坐标
    int x;
    int y;
    //子弹方向
    String direction;
    //子弹速度
    int speed = 15;
    //子弹是否存活
    boolean isLive = true;

    public Shoot(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        //边界条件
        while (true) {
            switch (direction) {
                case "up":
                    y -= speed;
                    break;
                case "down":
                    y += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
                case "right":
                    x += speed;
                    break;
            }
            System.out.println("子弹 x:" + x + "y:" + y);
            //碰到边界销毁
            if (!(x >= 0 && x <= 1200 && y >= 0 && y <= 800)) {
                isLive = false;
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
