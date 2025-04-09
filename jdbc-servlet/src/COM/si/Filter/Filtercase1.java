package COM.si.Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(value = {"/hg"})
public class Filtercase1  implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//FilterChain filterChain 处理多个拦截
        System.out.println("开始过滤------");
        System.out.println("过滤结束------");
        filterChain.doFilter(servletRequest, servletResponse);//继续执行Servlet
        String a=new String();

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
