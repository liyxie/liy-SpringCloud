package com.liy.auth.form;

import lombok.Data;
import lombok.ToString;

/**
 * @Author LiY
 * 用户登录对象
 */

@Data
@ToString
public class LoginBody {

    private String userName;

    private String password;

    private Integer sysType;

}
