package com.liy.model.oeder.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

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
@TableName("order")
public class OrderPo extends Model<OrderPo> {

    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("shop_id")
    private Long shopId;

    @TableField("user_id")
    private Long userId;

    @TableField("delivery_type")
    private Byte deliveryType;

    @TableField("shop_name")
    private String shopName;

    @TableField("total")
    private Long total;

    @TableField("status")
    private Byte status;

    @TableField("all_count")
    private Integer allCount;

    @TableField("pay_time")
    private Date payTime;

    @TableField("delivery_time")
    private Date deliveryTime;

    @TableField("finally_time")
    private Date finallyTime;

    @TableField("settled_time")
    private Date settledTime;

    @TableField("cancel_time")
    private Date cancelTime;

    @TableField("is_payed")
    private Boolean payed;

    @TableField("close_type")
    private Byte closeType;

    @TableField("delete_status")
    private Byte deleteStatus;

    @TableField("version")
    private Integer version;

    @TableField("order_addr_id")
    private Long orderAddrId;

    @Override
    public Serializable pkVal() {
        return this.orderId;
    }
}
