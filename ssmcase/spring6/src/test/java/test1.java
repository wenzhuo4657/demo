

import com.alibaba.druid.pool.DruidDataSource;
import firm.Emp;
import org.example.helloword;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.function.LongFunction;


public class test1 {
//    private Logger logger= LoggerFactory.getLogger(test1.class);

    @Test
    public void testHelloWorld(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-di.xml");
        Emp emp = (Emp) ac.getBean("emp",firm.Emp.class);
        emp.work();



//        logger.info("####日志调用成功！！！");

    }


    @Test
    public void testDataSource() throws SQLException {
        DruidDataSource dataSource =new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    @Test
    public  void testDataSource1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource dataSource =context.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getUsername());
    }
}
