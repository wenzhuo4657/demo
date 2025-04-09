package cn.wenzhuo4657;

import cn.wenzhuo4657.enity.Mybean;
import cn.wenzhuo4657.enity.Yourbean;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/8/29 9:02
 * @Version: 1.0
 * @description:
 *
 * 验证参数@Configuration(proxyBeanMethods = false)
 *
 *
 *
 */
@SpringBootTest
public class test implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
//========================1，容器中获取的依旧是单例bean=============================================
    @Test
    public  void test(){
        MybatisPlusInterceptor bean1= (MybatisPlusInterceptor) applicationContext.getBean("mybatisPlusInterceptor");
        MybatisPlusInterceptor bean2= (MybatisPlusInterceptor) applicationContext.getBean("mybatisPlusInterceptor");
        MybatisPlusInterceptor bean3= (MybatisPlusInterceptor) applicationContext.getBean("mybatisPlusInterceptor");
        MybatisPlusInterceptor bean4= (MybatisPlusInterceptor) applicationContext.getBean("mybatisPlusInterceptor");

    }
    @Test
    public  void test02(){
        DruidDataSource bean1= (DruidDataSource) applicationContext.getBean("druidDataSource");
        DruidDataSource bean2= (DruidDataSource) applicationContext.getBean("druidDataSource");
        DruidDataSource bean3= (DruidDataSource) applicationContext.getBean("druidDataSource");
        DruidDataSource bean4= (DruidDataSource) applicationContext.getBean("druidDataSource");

    }

//===================================2,代理在什么是否会生效，什么时候不生效=============================================


  /**
     *  des:
   *  当参数为false时，配置类内部被bean标识的方法内部，如果使用了bean，例如此处yourbean（mybean()）,
   *  这个方法调用不会被拦截生成代理或者说返回spring容器管理的实例，但是请注意，这并非意味着调用yourbean不是唯一实例，
   *  事实上，在容器内部注入的bean依旧是唯一实例，区别在于嵌套在内部的bean和容器中的bean。
     * */
    @Test
    public  void test03(){
        Yourbean bean =     this.applicationContext.getBean(Yourbean.class); // 第一行
        Yourbean bean1 =    this.applicationContext.getBean(Yourbean.class);  // 第二行
        Mybean myBean =     this.applicationContext.getBean(Mybean.class);    // 第三行
        myBean.hello();
        bean.hello();
        bean1.hello();
    }
}