package servlet;

import domain.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: revise
 * @author: wenzhuo4657
 * @date: 2024/3/24 10:31
 * @Version: 1.0
 * @description:
 */

@WebServlet(name = "reviseServlet", value = "/gs")
public class revise extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改密码
        Cookie[] cookies = req.getCookies();
        Cookie cokie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                cokie = cookie;
            }
        }
        if (cokie != null) {
            cokie.setValue(req.getParameter("password"));
        } else {

        }
        resp.addCookie(cokie);
        Response.success(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}