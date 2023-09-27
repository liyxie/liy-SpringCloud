package com.liy.model.user.po;

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
 * 省市区地区信息
 * </p>
 *
 * @author liy
 * @since 2023-09-13
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("area")
public class AreaPo extends Model<AreaPo> {

    @TableId(value = "area_id", type = IdType.AUTO)
    private Long areaId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 地址
     */
    @TableField("area_name")
    private String areaName;

    /**
     * 上级地址
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 等级（从1开始）
     */
    @TableField("level")
    private Integer level;

    @Override
    public Serializable pkVal() {
        return this.areaId;
    }
}
