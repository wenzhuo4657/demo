package org.example;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {

    @Autowired
    private JdbcTemplate   jdbcTemplate;

    @Test
//测试增删改功能
    public void testUpdate(){

        String sql = "DELETE FROM t_user WHERE balance=300";

        int result = jdbcTemplate.update(sql);
        System.out.println(result);
    }



}
