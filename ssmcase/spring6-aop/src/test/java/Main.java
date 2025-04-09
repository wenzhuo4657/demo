import com.aop.case1.Calculatorimpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {


    @Test
    public void testproxy() throws SQLException {

//(1,不使用xml文件
        // 创建并加载应用程序上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Calculatorimpl.class);
        context.refresh();

        // 获取Bean并使用它
        Calculatorimpl someComponent = context.getBean(Calculatorimpl.class);
        System.out.println(someComponent.add(1,1));

        // 关闭应用程序上下文
        context.close();

/*（2，使用xml文件

        ApplicationContext ac = new ClassPathXmlApplicationContext();
        Calculatorimpl userController = ac.getBean(Calculatorimpl.class);
        System.out.println(userController.add(1,1));
*/


//        但两种方式都需要注意，依赖注入或构造器注入不同于显示的new对象，是两种创建对象的方式，换句话说，new对象无法触发ioc容器管理，也就无法进行依赖注入
    }


}