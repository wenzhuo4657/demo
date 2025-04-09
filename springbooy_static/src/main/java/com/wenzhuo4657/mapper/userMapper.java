package com.wenzhuo4657.mapper;

import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.domain.userlogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface userMapper {
    List<User> finadll();

    userlogin login(userlogin user);
}
