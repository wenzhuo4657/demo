package servlet;

import connection.Login;
import domain.Response;
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
@WebServlet(name = "login", value = "/rs")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String password = req.getParameter("password");
//        String str = null;
//        str = Login.SelectOn_passwoed(name);
//        if (str.equals("")) {
//            Response.dad(resp, "该用户不存在");
//            return;
//        }
//        if (str.equals(password)) {
//            Cookie as = new Cookie("name", password);
//            as.setPath("/");//该cookie在所有路径下有效
//            as.setMaxAge(60 * 60);
//            resp.addCookie(as);
//            HttpSession session = req.getSession();
//            session.setAttribute("first", name);
//            req.getRequestDispatcher("/index").forward(req, resp);
//        } else {
//            Response.dad(resp, "密碼錯誤");
//        }
        Response.dad((HttpServletResponse) resp, "sucess!!");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}