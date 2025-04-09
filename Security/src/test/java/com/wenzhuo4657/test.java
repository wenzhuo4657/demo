package com.wenzhuo4657;


import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.mapper.Usermapper;
import com.wenzhuo4657.mapper.menumapper;
import com.wenzhuo4657.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.lettuce.core.ScriptOutputType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class test {


    @Autowired
    Usermapper usermapper;


    @Test
    public  void j() throws Exception {
        Claims claims = JwtUtil.parseJWT("$2a$10$Jnq31rRkNV3RNzXe0REsEOSKaYK8UgVZZqlNlNXqn.JeVcj2NdeZy");
        System.out.println(claims.getSubject());
    }


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private menumapper menumapper;
    @Test
    public  void test(){
        System.out.println(menumapper.Permissions(2));


    }

}
