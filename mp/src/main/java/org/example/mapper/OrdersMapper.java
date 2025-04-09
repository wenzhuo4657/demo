package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.example.domian.Orders;


@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    IPage<Orders> findAllOrders(Page<Orders> page);
}
