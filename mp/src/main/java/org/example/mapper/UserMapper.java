package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domian.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Mapper
public interface UserMapper extends BaseMapper<User>{
    User findMyUser(Long id);

}
