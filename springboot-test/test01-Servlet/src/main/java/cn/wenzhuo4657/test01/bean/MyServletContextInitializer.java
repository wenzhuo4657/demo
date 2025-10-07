package cn.wenzhuo4657.test01.bean;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Set;



@Component
public class MyServletContextInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic test = servletContext.addServlet("test", "cn.wenzhuo4657.test01.servlet.test01Servlet");

        test.addMapping("/test");
        test.setLoadOnStartup(1);



        System.out.println("MyServletContextInitializer初始化成功！！");

    }


}
