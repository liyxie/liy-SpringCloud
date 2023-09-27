package com.liy.common.core.web.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author LiY
 * 基础对象
 */

@Data
@ToString
public class BsaePo {

    private static final long serialVersionUID = 1L;

    @TableField(value = "create_by", exist = false)
    private String createBy;

    @TableField(value = "create_time", exist = false)
    private Date createTime;

    @TableField(value = "update_by", exist = false)
    private String updateBy;

    @TableField(value = "update_time", exist = false)
    private Date updateTime;

    @TableField(value = "remark", exist = false)
    private String remark;
}
