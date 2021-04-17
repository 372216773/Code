package com.wj;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {

    //接收任何请求
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        System.out.println("HelloServlet2 coming......");

        req.getRequestDispatcher("HelloServlet").forward(req,res);
    }
}
