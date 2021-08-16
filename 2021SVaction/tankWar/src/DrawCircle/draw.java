package DrawCircle;

import javax.swing.*;
import java.awt.*;

public class draw extends JFrame {

    /*
    JFrame 窗口框架
    Graphics g 画笔
    Graphics提供了很多绘图的方法
     */

    //定义一个面板
    MyPanel panel;

    public draw() {
        //初始化面板
        panel = new MyPanel();
        //把面板放到窗口
        this.add(panel);
        //设置框的宽高
        this.setSize(1096, 800);
        //设置可展示
        this.setVisible(true);
        //点击窗口的退出,程序就会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        draw draw = new draw();
    }
}

class MyPanel extends JPanel {
    //绘图的方法()
    @Override
    public void paint(Graphics g) {
        /*
        出现以下情况,程序就会自动调用paint()方法
        1.当组件第一次在屏幕上显示的时候,
        2.窗口最小化,再最大化,
        3.窗口的大小发生变化,
        4.repaint()被调用,
         */
        //调用父类的方法完成初始化
        super.paint(g);
        //椭圆形
        //g.drawOval(20, 20, 100, 100);

        //直线
        //g.drawLine(10, 10, 200, 200);

        //矩形边框
        //g.drawRect(10, 10, 100, 100);

        //设置颜色
        //g.setColor(Color.red);
        //设置字体
        //g.setFont(new Font("隶书",Font.BOLD,100));
        //g.drawString("北京欢迎你",100,100);

        //填充矩形
        //g.fillRect(10,10,100,100);

        //填充椭圆
        //g.fillOval(10,10,100,100);

        //获取图片资源    从根目录获取资源
        //Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/dalisi.jpg"));
        //g.drawImage(image,10,10,1078,700,this);
    }
}
