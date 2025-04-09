package filter;

import domain.Response;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @className: cookie
 * @author: wenzhuo4657
 * @date: 2024/3/24 11:16
 * @Version: 1.0
 * @description:
 */
@WebFilter(value = "/index")
public class cookie implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        Response.dad((HttpServletResponse) servletResponse, "dad");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}