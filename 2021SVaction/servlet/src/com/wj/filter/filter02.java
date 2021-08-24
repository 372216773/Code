package com.wj.filter;

import javax.servlet.*;
import java.io.IOException;

public class filter02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化init(用来拦截访问servlet04的请求)......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求,filter说:站住,你刚刚通过了所有人经过都会检查的关卡,现在要进这个地方(servlet04),看看你的证件是否符合我们的要求");
        System.out.println("我的id是" + servletRequest.getParameter("id"));
        System.out.println("id=" + servletRequest.getParameter("id") + "符合要求,你有权访问这个servlet");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("拦截响应,filter说:id为" + servletRequest.getParameter("id") + "的用户,这里是servlet04特定的filter,您事情办完了(doFilter方法执行完),欢迎下次光临");
    }

    @Override
    public void destroy() {

    }
}
