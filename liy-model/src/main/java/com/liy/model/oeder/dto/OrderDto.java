package com.liy.model.oeder.dto;

import com.liy.model.product.dto.ShopCartItemDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;


/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author liy
 * @since 2023-09-08
 */
@Getter
@Setter
@Accessors(chain = true)
public class OrderDto {


    private ShopCartItemDTO shopCartItem;

    @NotNull(message = "配送类型不能为空")
    private Integer dvyType;

    @NotNull(message = "地址不能为空")
    private Long addrId;


}
