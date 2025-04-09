package com.wenzhuo4657.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenzhuo4657.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface menumapper extends BaseMapper<Menu> {
    List<String>  Permissions(long userid);
}
