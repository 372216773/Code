package com.wj.cookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet05 extends HttpServlet {
    ServletContext servletContext = null;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf8");
/*        //通过设置servletContext对象来获得访问次数
        //整个web应用只有这一个servletContext对象
        servletContext = req.getServletContext();
        if (servletContext.getAttribute("count") == null) {
            servletContext.setAttribute("count", 1);
        } else {
            int count = (int) servletContext.getAttribute("count");
            servletContext.setAttribute("count", count + 1);
        }
        resp.getWriter().write("这是你的第" + servletContext.getAttribute("count") + "次访问");*/

        //第一次访问本站点(服务)
        if (req.getCookies() == null) {
            Cookie cookie = new Cookie("AccessNum", "1");
            cookie.setMaxAge(60 * 60);//1小时
            resp.addCookie(cookie);
            resp.getWriter().write("我是第1次访问");
        }
        for (Cookie recCookie : req.getCookies()) {
            if (recCookie.getName().equals("AccessNum")) {
                Integer accessNum = Integer.valueOf(recCookie.getValue());
                accessNum++;
                Cookie cookie = new Cookie("AccessNum", String.valueOf(accessNum));
                cookie.setMaxAge(60 * 60);//1小时
                resp.addCookie(cookie);
                resp.getWriter().println("我是第" + accessNum + "次访问");
            }
        }
    }
}
