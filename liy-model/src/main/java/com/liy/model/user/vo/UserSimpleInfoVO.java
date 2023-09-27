package com.liy.model.user.vo;


/**
 * @Author LiY
 * 简单用户对象Vo
 */

public class UserSimpleInfoVO {

    private Long userId;

    private String nickName;

    private String avatar;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserSimpleInfoVO{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
