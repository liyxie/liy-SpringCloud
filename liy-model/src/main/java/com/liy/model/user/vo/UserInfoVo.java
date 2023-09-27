package com.liy.model.user.vo;

import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author liy
 * @since 2023-09-04
 */

@Data
@ToString
public class UserInfoVo {

    private Long userId;

    private String userName;

    private String nickName;

    private Integer status;

    private String avatar;

    private String userType;
}
