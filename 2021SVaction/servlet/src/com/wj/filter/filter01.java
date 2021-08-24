package com.wj.filter;

import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import java.io.IOException;

//过滤器
public class filter01 implements Filter {
    /**
     * 在tomcat启动时,自动初始化
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化init(用来拦截所有请求)......");
    }

    /**
     * 根据web.xml中的配置进行拦截请求,相当于servlet
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求,filter(拦截所有人)说:站住,看看你的证件(进行检查操作,看看是否放行请求)");
        System.out.println("我的id是" + servletRequest.getParameter("id"));
        System.out.println("这个id是可以通过的,请进");
        //放行请求之前都属于拦截请求
        //放行请求,可以添加条件,条件满足就放行
        filterChain.doFilter(servletRequest, servletResponse);
        //放行请求后做的事,属于拦截响应
        String id = (String) servletRequest.getParameter("id");
        System.out.println("拦截响应,filter说:id为" + id + "的用户,您事情办完了(doFilter方法执行完),欢迎下次光临");
    }

    /**
     * 在tomcat停止时调用
     */
    @Override
    public void destroy() {
        System.out.println("filter销毁destroy......");
    }
}
