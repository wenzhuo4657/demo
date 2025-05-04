package test02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import test02.enity.Book;


/**
 * @className: WebTest
 * @author: wenzhuo4657
 * @date: 2024/8/27 20:21
 * @Version: 1.0
 * @description:  发送虚拟请求，验证rest控制器（又名mvc控制器）是否可以正常的工作，
 * 注意：区别于http客户端发送请求，实质上是两个实体通过网络协议进行通信，
 * 此处使用mockMvc并不启动完整web服务，仅仅是在测试环境中运行。
 *
 *注解组合1：
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
 * 启动web服务，其参数表示以默认端口8080启动程序
 *
 * @AutoConfigureMockMvc
 * 自动配置测试环境bean :mockMvc
 *
 *注解组合2：
 * @WebMvcTest: 其内部注解封装的更全面，测试日志中没有端口，似乎从效率上高于前两个，且作用上更丰富
 *

 *
 * 无论是哪一种注解组合，都无法直接使用构造器注入bean，或者说没有默认构造器使用springDI的机制，必须使用 @Autowired注解标识
 */


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureMockMvc
@WebMvcTest
public class WebTest {

//    Book book;
//
//    @Autowired
//    public WebTest(Book book) {
//        this.book = book;
//    }

    @Test
    public  void test(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder xxbuilder= MockMvcRequestBuilders.get("/books");
        mockMvc.perform(xxbuilder);
//        System.out.println(book.a);
    }


//    ========================判断虚拟请求是否成功============================================

      /**
         *  des: 通过执行状态/响应状态来判断测试是否成功
         * */
    @Test
    public  void test02(@Autowired MockMvc mockMvc) throws Exception {
//       1. 获取真实值,此处已经验证了一次控制器，并得到返回结果
        MockHttpServletRequestBuilder xxbuilder= MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockMvc.perform(xxbuilder);

//        2,获取Mockmvc虚拟调用正常访问的期望状态（状态码200、json格式等）
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

//        3，比较是否成功
        perform.andExpect(ok);
    }


      /**
         *  des: 根据响应结果进行判断，这里为了实现自动化，必须要给出预期结果，这意味着如果不能给出预期结果就不能使用这种方法。
         * */
    @Test
    public  void test03(@Autowired MockMvc mockMvc) throws Exception {
        //       1. 获取真实值,此处已经验证了一次控制器，并得到返回结果
        MockHttpServletRequestBuilder xxbuilder= MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockMvc.perform(xxbuilder);

//        2,获取Mockmvc虚拟调用的访问响应主体断言的格式，并且手动给出预期返回结果
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("getById方法正在运行");

//        3，比较是否成功
        perform.andExpect(result);
    }

      /**
         *  des: 根据响应头来判断是否调用成功
         * */
    @Test
    public  void test04(@Autowired MockMvc mockMvc) throws Exception {
        //       1. 获取真实值,此处已经验证了一次控制器，并得到返回结果
        MockHttpServletRequestBuilder xxbuilder= MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockMvc.perform(xxbuilder);

//        2,获取Mockmvc虚拟调用的访问响应主体断言的格式，并且手动给出预期返回结果
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher result = header.string("Content-Type","text/plain;charset=UTF-8");

//        3，比较是否成功
        perform.andExpect(result);
    }






}