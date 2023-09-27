package com.liy.model.user.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author liy
 * @since 2023-09-04
 */

@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPo extends Model<UserPo> {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("nick_name")
    private String nickName;

    @TableField("user_type")
    private String userType;

    @TableField("email")
    private String email;

    @TableField("phonenumber")
    private String phonenumber;

    @TableField("sex")
    private String sex;

    @TableField("avatar")
    private String avatar;

    @TableField("password")
    private String password;

    @TableField("status")
    private String status;

    @TableField("del_flag")
    private String delFlag;

    @TableField("login_ip")
    private String loginIp;

    @TableField("login_date")
    private Date loginDate;

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

    @Override
    public Serializable pkVal() {
        return this.userId;
    }
}
