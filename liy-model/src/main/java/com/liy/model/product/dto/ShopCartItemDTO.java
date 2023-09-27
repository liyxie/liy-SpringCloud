package com.liy.model.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author LiY
 * 购物车
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShopCartItemDTO {

    @NotNull(message = "产品ID不能为空")
    private Long spuId;

    @NotNull(message = "skuId不能为空")
    private Long skuId;

    @NotNull(message = "商品数量不能为空")
    @Min(value = 1,message = "商品数量不能为空")
    private Integer count;

    @NotNull(message = "店铺id不能为空")
    private Long shopId;


}
