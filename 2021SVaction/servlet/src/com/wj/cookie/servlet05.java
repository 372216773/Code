package com.wj.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet05 extends HttpServlet {
    private static int count = 0;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("cookieName", "cookieValue");
        if (req.getCookies() == null) {
            cookie.setComment("这是cookie的注释");
            //过期时间
            cookie.setMaxAge(3000);
            resp.addCookie(cookie);
        }
    }
}
