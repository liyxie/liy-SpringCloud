package com.liy.model.user.auth;

import java.io.Serializable;

/**
 * <p>
 * 统一账户信息
 * </p>
 *
 * @author liy
 * @since 2023-09-07
 */
public class AuthAccountInfoPo implements Serializable{

    private Long uid;

    private String username;

    private Integer sysType;

    private Long userId;

    private Long tenantId;

    private Integer isAdmin;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public AuthAccountInfoPo(){}

    public AuthAccountInfoPo(AuthAccountBo authAccountBo){
        this.uid = authAccountBo.getUid();
        this.userId = authAccountBo.getUserId();
        this.sysType = authAccountBo.getSysType();
        this.tenantId = authAccountBo.getTenantId();
        this.username = authAccountBo.getUsername();
        this.isAdmin = authAccountBo.getIsAdmin();
    }

    @Override
    public String toString() {
        return "AuthAccountInfoPo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", sysType=" + sysType +
                ", userId=" + userId +
                ", tenantId=" + tenantId +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
