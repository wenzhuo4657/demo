package cn.wenzhuo4657.test01.bean;

import jakarta.servlet.ServletContext;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;


@Configuration
public class MyDemoBean implements ApplicationListener<ApplicationStartedEvent> {

	private ServletContext servletContext;

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {


		ApplicationContext applicationContext = event.getApplicationContext();
		this.servletContext = ((WebApplicationContext) applicationContext).getServletContext();
	}

}