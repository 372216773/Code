package TankWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/*
绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义坦克
    Hero hero = null;
    Vector<Enemy> enemies = new Vector<>();
    int enemyNum = 3;
    int Width;
    int Height;

    public MyPanel() {
        //初始化坦克,初始方位,速度
        hero = new Hero(0, 0, 3);
        for (int i = 0; i < this.enemyNum; i++) {
            enemies.add(new Enemy(100*(i+1), 0, 1));
        }
    }

    @Override
    public void paint(Graphics g) {
        //调用父类构造器完成初始化
        super.paint(g);
        g.setColor(Color.decode("#6e6e6e"));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        drawTank(hero.getX(), hero.getY(), g, "hero", hero.getDirection());
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            drawTank(enemy.getX(), enemy.getY(), g, "enemy", enemy.getDirection());
        }
    }

    /**
     * @param x         x坐标
     * @param y         y坐标
     * @param g         画笔
     * @param direction 坦克方向
     * @param type      坦克类型
     */
    public void drawTank(int x, int y, Graphics g, String type, String direction) {
        //坦克分类
        switch (type) {
            case "hero":
                g.setColor(Color.CYAN);
                break;
            case "enemy":
                g.setColor(Color.yellow);
                break;
            default:
                System.out.println("这不是我要的坦克!");
        }

        //根据坦克(头)的方向,绘制坦克
        switch (direction) {
            case "up":
                tankDirection_up(x, y, g);
                break;
            case "down":
                tankDirection_down(x, y, g);
                break;
            case "left":
                tankDirection_left(x, y, g);
                break;
            case "right":
                tankDirection_right(x, y, g);
                break;
            default:
                System.out.println("你要干嘛!");
        }
    }

    public static void tankDirection_up(int x, int y, Graphics g) {
        //左轮子
        g.fill3DRect(x, y, 10, 60, false);
        //右轮子
        g.fill3DRect(x + 30, y, 10, 60, false);
        //body
        g.fill3DRect(x + 10, y + 10, 20, 40, false);
        //盖
        g.fillOval(x + 10, y + 20, 20, 20);
        //炮筒
        g.drawLine(x + 20, y, x + 20, y + 30);
    }

    public static void tankDirection_down(int x, int y, Graphics g) {
        //左轮子
        g.fill3DRect(x, y, 10, 60, false);
        //右轮子
        g.fill3DRect(x + 30, y, 10, 60, false);
        //body
        g.fill3DRect(x + 10, y + 10, 20, 40, false);
        //盖
        g.fillOval(x + 10, y + 20, 20, 20);
        //炮筒
        g.drawLine(x + 20, y + 30, x + 20, y + 60);
    }

    public static void tankDirection_left(int x, int y, Graphics g) {
        //左轮子
        g.fill3DRect(x, y, 60, 10, false);
        //右轮子
        g.fill3DRect(x, y + 30, 60, 10, false);
        //body
        g.fill3DRect(x + 10, y + 10, 40, 20, false);
        //盖
        g.fillOval(x + 20, y + 10, 20, 20);
        //炮筒
        g.drawLine(x, y + 20, x + 30, y + 20);
    }

    public static void tankDirection_right(int x, int y, Graphics g) {
        //左轮子
        g.fill3DRect(x, y, 60, 10, false);
        //右轮子
        g.fill3DRect(x, y + 30, 60, 10, false);
        //body
        g.fill3DRect(x + 10, y + 10, 40, 20, false);
        //盖
        g.fillOval(x + 20, y + 10, 20, 20);
        //炮筒
        g.drawLine(x + 30, y + 20, x + 60, y + 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyCode = (char) e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                hero.setDirection("up");
                if (hero.getY() > 0) {
                    hero.MoveUp();
                }
                System.out.println("x:  " + hero.getX() + "y:  " + hero.getY());
                break;
            case KeyEvent.VK_DOWN:
                hero.setDirection("down");
                if (hero.getY()+60 < this.getHeight()) {
                    hero.MoveDown();
                }
                System.out.println("x:  " + hero.getX() + "y:  " + hero.getY());
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirection("left");
                if (hero.getX() > 0) {
                    hero.MoveLeft();
                }
                System.out.println("x:  " + hero.getX() + "y:  " + hero.getY());
                break;
            case KeyEvent.VK_RIGHT:
                hero.setDirection("right");
                if (hero.getX()+60 < this.getWidth()) {
                    hero.MoveRight();
                }
                System.out.println("x:  " + hero.getX() + "y:  " + hero.getY());
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setWidth(int width) {
        this.Width = width;
    }

    public void setHeight(int height) {
        this.Height = height;
    }

    public int getWidth() {
        return this.Width;
    }

    public int getHeight() {
        return this.Height;
    }
}
