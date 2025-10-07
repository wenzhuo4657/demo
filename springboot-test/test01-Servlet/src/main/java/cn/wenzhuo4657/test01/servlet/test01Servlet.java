package cn.wenzhuo4657.test01.servlet;

import jakarta.servlet.*;

import java.io.IOException;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;


public class test01Servlet implements Servlet {

    private ServletConfig servletConfig;



    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        System.out.println("test01Servlet初始化成功！！");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 字符编码 & 响应类型
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        // 参数与计数
        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "访客";
        }
        String greeting = servletConfig.getInitParameter("greeting");
        if (greeting == null || greeting.isBlank()) {
            greeting = "Hello";
        }



        // 输出 HTML
        try (PrintWriter out = res.getWriter()) {
            out.println("""
                    <!DOCTYPE html>
                    <html lang="zh-CN">
                    <head><meta charset="UTF-8"><title>test01Servlet 示例</title></head>
                    <body>
                    """);
            out.printf("<h2>%s，%s！</h2>%n", greeting, escape(name));
            out.printf("<p>这是第 <strong>%d</strong> 次访问。</p>%n", 1);

            out.println("""
                    <hr/>
                    <form method="get" action="hello">
                      <label>输入你的名字：<input name="name" placeholder="如：小王"/></label>
                      <button type="submit">提交</button>
                    </form>
                    <p>也可以直接访问：<code>/hello?name=Jack</code></p>
                    </body></html>
                    """);
        }
    }

    @Override
    public String getServletInfo() {
        return "A minimal Jakarta Servlet example with counter and greeting.";
    }

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }


    private static String escape(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}

