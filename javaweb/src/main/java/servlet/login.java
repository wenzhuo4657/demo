package servlet;

import connection.Login;
import domain.response;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @className: login
 * @author: wenzhuo4657
 * @date: 2024/3/24 10:49
 * @Version: 1.0
 * @description:
 */
@WebServlet(name ="login" ,value = "/rs")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        //获取cookid，如果没有对应cookie则重新创建，如果有则进行比对
        Cookie[]  cookies=req.getCookies();
        Cookie user=null;
        for(Cookie cookie: cookies){
           if (cookie.getName().equals("user")){
               user=cookie;
           }
        }

        if (user!=null){
            if (user.getValue().equals(password)){
                //从cookie中校验
                HttpSession session=req.getSession();
                session.setAttribute("first",name);

            }else {
                response.dad(resp);
            }
        }else {
//            从数据库中校验，并设置cookie
            boolean is=true;
            String tr = null;
            try {
                tr = Login.loginOn_passwoed(name);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String[] t=tr.split(",");
            if (t.length==0){
//                response.dad(resp);
//                如果不存在该用户，则进行注册，
                LinkedList

            }else {
//                如果存在进行校验


            }


            if (is){
                Cookie as=new Cookie("name",password);
                as.setPath("/");//该cookie在所有路径下有效
                as.setMaxAge(60*60);
                resp.addCookie(as);
                HttpSession session=req.getSession();
                session.setAttribute("first",name);
            }

        }
        req.getRequestDispatcher("/index").forward(req,resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}