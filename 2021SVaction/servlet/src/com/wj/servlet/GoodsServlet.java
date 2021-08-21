package com.wj.servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class GoodsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String sql = "select * from goods";
        Object[] params = new Object[]{};
        try {
            List<Goods> goodsList = (List<Goods>) JDBCUtil.getQueryRunner().query(sql, params, new BeanListHandler(Goods.class));

                resp.getWriter().write("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Title</title>\n" +
                        "    <style>\n" +
                        "        #div_1 {\n" +
                        "            width: 1200px;\n" +
                        "            height: 2000px;\n" +
                        "            display: flex;\n" +
                        "            flex-direction: row;\n" +
                        "            justify-content: center;\n" +
                        "            align-items: center;\n" +
                        "        }\n" +
                        "        #div_1>div {\n" +
                        "            width: 400px;\n" +
                        "            height: 500px;\n" +
                        "            border: 1px solid black;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div id=\"div_1\">\n" );

            for (Goods good : goodsList) {
                resp.getWriter().write("<div>"+good.getId());
                resp.getWriter().write(good.getTitle());
                resp.getWriter().write((int) good.getPrice());
                resp.getWriter().write("  <img src="+good.getImage()+" alt=\"\"></div>");
            }
                      resp.getWriter().write("</div>\n" +
                              "\n" +
                              "</body>\n" +
                              "</html>");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取数据失败!");
        }
    }
}
