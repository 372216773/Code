package com.wj;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Servlet4 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //获取注册Servlet时配置的初始化参数
        System.out.println(config.getInitParameter("myName"));

        //获取全局配置的context-param初始化参数,(可以配置多个,但是建议配置一个)
        System.out.println("全局初始化参数: " + getServletContext().getInitParameter("myName1"));

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //创建资源对象
        Properties properties = new Properties();

        //给资源对象加载配置好的数据
        properties.load(Servlet4.class.getClassLoader().getResourceAsStream("druid.properties"));

        String sql = "select * from goods";
        Object query=null;

        //200 --> ok
        System.out.println(resp.getStatus());

        //设置响应头数据
        resp.setHeader("aa","admin");
        resp.setHeader("bb","admin123");

        //设置http状态码,如果这个状态码不设置,服务器会根据自己内部的来设置
        //resp.setStatus(404);

        //1.
        //设置响应实体
        //表示返回的格式,html还是xml这些
        resp.setContentType("text/html");
        //设置编码格式的
        resp.setCharacterEncoding("UTF-8");

        //2.
        //resp.setContentType("text/html;charset=utf8");

        //3.
        //设置content-type
        //resp.setHeader("content-type","text/html;utf-8");

        resp.getWriter().println("<!DOCTYPE html>" );
        resp.getWriter().println("<head>");
        resp.getWriter().println("<meta charset='UTF-8'>");
        resp.getWriter().println("<title>goods</title>");
        resp.getWriter().println("<style>body{width:1380px;height:3200px;display:flex;flex-wrap:wrap;flex-direction:row;justify-content:center;align-items:center;margin:0 auto;}.c1{width:460px;height:460px;display:flex;flex-wrap:wrap;flex-direction:column;justify-content:center;align-items:center;}.c2{width:460px;height:40px;}img{display:blocks;width:80px;height:80px;}h5{background-color:#8cd3ec; height:80px; width: 460px;text-align:center; line-height:40px;}</style>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");

        try {
            //jar:druid连接池
            //创建连接池对象,配置好的资源对象传给连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //jar:commons-DBUtils  -->对JDBC封装
            //创建DBUtils的核心操作类,要操作对象为dataSource
            QueryRunner queryRunner = new QueryRunner(dataSource);
            List<Map<String, Object>> query1 = (List<Map<String, Object>>) queryRunner.query(sql, new MapListHandler());
            for (Map<String, Object> stringObjectMap : query1) {
                String title = (String) stringObjectMap.get("title");
                String description = (String) stringObjectMap.get("description");
                String price = stringObjectMap.get("price").toString();
                String image = (String) stringObjectMap.get("image");
                String gmt_create = stringObjectMap.get("gmt_create").toString();
                resp.getWriter().write("<div class='c1'>");
                resp.getWriter().write("<h5>");
                resp.getWriter().write(title);
                resp.getWriter().write("</h5>");
                resp.getWriter().write("<div class='c2'>");
                resp.getWriter().write(description);
                resp.getWriter().write("</div>");
                resp.getWriter().write("<img src='" + image +"'>");
                resp.getWriter().write("<div>");
                resp.getWriter().write("price: " + price);
                resp.getWriter().write("</div>");
                resp.getWriter().write("<div>");
                resp.getWriter().write("gmt_create: " +gmt_create );
                resp.getWriter().write("</div>");
                resp.getWriter().write("</div>");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");

    }

}
