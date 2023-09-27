package com.liy.model.product.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 商品三级分类
 * </p>
 *
 * @author liy
 * @since 2023-09-23
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("category")
@ToString
public class CategoryPo extends Model<CategoryPo> {

    /**
     * 分类id
     */
    @TableId(value = "cat_id", type = IdType.AUTO)
    private Long catId;

    /**
     * 分类名称
     */
    @TableField("name")
    private String name;

    /**
     * 父分类id
     */
    @TableField("parent_cid")
    private Long parentCid;

    /**
     * 层级
     */
    @TableField("cat_level")
    private Integer catLevel;

    /**
     * 是否显示[0-不显示，1显示]
     */
    @TableField("show_status")
    private Byte showStatus;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 图标地址
     */
    @TableField("icon")
    private String icon;

    /**
     * 计量单位
     */
    @TableField("product_unit")
    private String productUnit;

    /**
     * 商品数量
     */
    @TableField("product_count")
    private Integer productCount;



    @Override
    public Serializable pkVal() {
        return this.catId;
    }
}
