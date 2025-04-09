package servlet;

import connection.Login;
import domain.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: addUser
 * @author: wenzhuo4657
 * @date: 2024/4/18 16:14
 * @Version: 1.0
 * @description:
 */
@WebServlet(name = "AddUser", value = "/addUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        if (!password1.equals(password2)) {
            Response.dad(resp, "密碼不一致");
            return;
        }
        Login.insertUser(name, password1);
        Response.success(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}