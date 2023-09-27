package com.liy.module.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liy.model.oeder.po.OrderPo;
import com.liy.module.order.mapper.OrderMapper;
import com.liy.module.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author liy
 * @since 2023-09-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderPo> implements OrderService {

}
