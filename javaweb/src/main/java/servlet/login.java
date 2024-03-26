package servlet;

import domain.response;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


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
                HttpSession session=req.getSession();
                session.setAttribute("first",name);
                req.getRequestDispatcher("/index").forward(req,resp);
            }else {
                response.dad(resp);
            }
        }else {
            Cookie as=new Cookie("name",password);
            as.setPath("/");//该cookie在所有路径下有效
            as.setMaxAge(60*60);
            
            resp.addCookie(as);
            HttpSession session=req.getSession();
            session.setAttribute("first",name);
            req.getRequestDispatcher("/index").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}