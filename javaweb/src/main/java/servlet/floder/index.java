package servlet.floder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @className: index
 * @author: wenzhuo4657
 * @date: 2024/3/24 10:35
 * @Version: 1.0
 * @description:
 */
@WebServlet(name = "index", value = "/index")
public class index extends HttpServlet {
    static String num = "num";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        if (!Objects.isNull(servletContext.getAttribute(num))) {
            servletContext.setAttribute(num, (Integer) servletContext.getAttribute(num) + 1);
        } else {
            servletContext.setAttribute(num, 1);
        }
        System.out.println("访问：" + servletContext.getAttribute(num));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}