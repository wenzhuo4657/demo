package study.lis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import study.lis.study1.controller.hysController;
import study.lis.study1.controller.stuController;
import study.lis.study1.domain.stu;

import javax.annotation.Resource;

/**
 * @className: ApiTest
 * @author: wenzhuo4657
 * @date: 2024/5/27 11:52
 * @Version: 1.0
 * @description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"study.lis.study1"})
public class ApiTest {

    @Resource
    private stuController st;


    @Resource
    private hysController hys;
  /**
     *  des:，注解管理bean， 构造器注入
     * */
    @Test
    public void test(){
        System.out.println(st.getTerHys());
    }


      /**
         *  des: 注解管理bean，构造器注入，list、map集合
         * */

      @Test
    public void testList_Map(){
          System.out.println(hys);
      }


    @Autowired(required = false)
    private stu  stu;

        /**
           *  des: 根据配置文件的属性值来决定是否注入
           * */
      @Test
    public void test_Config(){
          System.out.println(stu);
      }


}