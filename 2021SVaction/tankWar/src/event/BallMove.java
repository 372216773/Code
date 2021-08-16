package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
小球的移动
 */
public class BallMove extends JFrame {

    MyPanel panel;

    public BallMove() {
        //初始化面板
        panel = new MyPanel();
        this.add(panel);
        this.setSize(500, 400);
        //窗口JFrame对象加入监听键盘事件
        this.addKeyListener(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BallMove();
    }
}

//KeyListener监听键盘时间
class MyPanel extends JPanel implements KeyListener {

    //小球初始位置
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 40, 40);
    }

    //字符输出
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按键按下
    @Override
    public void keyPressed(KeyEvent e) {
        char keyCode = (char) e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                //重绘(刷新)
                if (y > 0) {
                    y--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (y < 400) {
                    y++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0) {
                    x--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (x < 500) {
                    x++;
                }
                break;
        }
        //重绘
        repaint();
    }

    //按键松开
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
