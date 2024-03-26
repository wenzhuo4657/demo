package filter;

import domain.response;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @className: cookie
 * @author: wenzhuo4657
 * @date: 2024/3/24 11:16
 * @Version: 1.0
 * @description:
 */
@WebFilter(value = "/")
public class cookie implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("name")){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        response.dad((HttpServletResponse) servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}