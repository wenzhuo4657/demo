package COM.si.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = {"/hu"})
public class SevrletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie as=new Cookie("name","gavin");
        Cookie ab=new Cookie("name","jflask");

        as.setPath("/javas_war_exploded/get");
        ab.setPath("/javas_war_exploded");
        as.setMaxAge(60*60);
        ab.setMaxAge(60*60);
        resp.addCookie(as);
        resp.addCookie(ab);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
