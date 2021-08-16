package TankWar;

import javax.swing.*;

public class Game extends JFrame {

    MyPanel panel;

    public Game() {
        //初始化面板
        panel = new MyPanel();
        panel.setWidth(1200);
        panel.setHeight(800);
        //把画板放到窗口
        this.add(panel);
        Thread thread = new Thread(panel);
        thread.start();
        //添加键盘监听事件
        this.addKeyListener(panel);
        //设置窗口的宽高
        this.setSize(1200,800);
        //可显示
        this.setVisible(true);
        //随着窗口关闭,程序结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Game();
    }


}
