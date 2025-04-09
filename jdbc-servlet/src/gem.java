import COM.si.dao.impl.AdminDaoImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import  COM.si.Service.impl.adminserviceimpl;
import COM.si.entity.Admin;

@WebServlet(value = {"/rs"})
public class gem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("这是get");
        String a=req.getParameter("jack");
        String b=req.getParameter("password");

            System.out.println("成功");


       adminserviceimpl adminserviceimpl=new adminserviceimpl();
        Admin ab= adminserviceimpl.login(a,b);
        List abb=new ArrayList<>();
        abb.add(ab);
        req.setAttribute("List",abb);
        req.getRequestDispatcher("/mi").forward(req,resp);


    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是post");
        String a=req.getParameter("jack");
        String b=req.getParameter("password");
        System.out.println("a:"+a+"\nb:"+b);

        //设置服务器端的编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type","text/html;charset=utf-8");
        PrintWriter y=resp.getWriter();
        y.println("登录成功");
    }
}
