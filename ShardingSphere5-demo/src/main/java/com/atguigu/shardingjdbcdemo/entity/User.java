package com.atguigu.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @className: User
 * @author: wenzhuo4657
 * @date: 2024/7/28 11:07
 * @Version: 1.0
 * @description:
 */
@TableName("t_user")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String uname;
}