package com.liy.module.order.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liy.model.oeder.po.OrderPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单信息 Mapper 接口
 * </p>
 *
 * @author liy
 * @since 2023-09-08
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPo> {

}
