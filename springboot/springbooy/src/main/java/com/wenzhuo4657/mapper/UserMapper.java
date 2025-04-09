package com.wenzhuo4657.mapper;

import com.wenzhuo4657.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    public List<User> findAll();
}
