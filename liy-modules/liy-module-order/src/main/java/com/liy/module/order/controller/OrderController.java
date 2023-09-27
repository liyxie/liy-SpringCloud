package com.liy.module.order.controller;

import com.liy.common.core.web.domain.AjaxResult;
import com.liy.common.security.AuthUserContext;
import com.liy.model.oeder.dto.OrderDto;
import com.liy.module.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单信息 前端控制器
 * </p>
 *
 * @author liy
 * @since 2023-09-08
 */
@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @description: 生成订单
     * @author: liy
     * @param:
     * @return:
     **/
    @PostMapping("/confirm")
    public AjaxResult confirm(@Validated @RequestBody OrderDto orderDto){
        Long userId = AuthUserContext.get().getUserId();

//        ShopCartOrderMergerVO

        return null;

    }

    //

}
