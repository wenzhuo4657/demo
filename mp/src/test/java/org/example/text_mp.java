package org.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.domian.Orders;
import org.example.domian.User;
import org.example.mapper.OrdersMapper;
import org.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
public class text_mp {


    @Autowired
    private UserMapper user;

    @Autowired
    private OrdersMapper orders;


    @Test
    public  void test(){
        User user1=new User();
        user1.setId(2L);
        user1.setAge(1000);
        user.updateById(user1);

    }

    @Test
    public void testSelect02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(User.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return "user_name".equals(tableFieldInfo.getColumn());
            }
        });
        List<User> users = user.selectList(queryWrapper);
        System.out.println(users);

    }

    @Test
    public  void testPage(){
        IPage<User> iPage=new Page<>();
        iPage.setPages(2);
        iPage.setSize(2);
        iPage.setCurrent(2);
        IPage<User> iPage1=user.selectPage(iPage,null);
        System.out.println(iPage1);
        System.out.println("=======");
        IPage<Orders> iPage2=new Page<>();
        iPage.setPages(2);
        iPage.setSize(2);
        iPage.setCurrent(2);
        orders.findAllOrders((Page)iPage2);
    }

}


