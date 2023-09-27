package com.liy.model.user.auth.token;

/**
 * @Author LiY
 * token信息
 *
 */


public class TokenInfoVo {

    private String accessToken;

    private String refreshToken;

    // 时限/秒
    private Long expiresIn;

    public TokenInfoVo(TokenInfoPo tokenInfoPo) {
        this.accessToken = tokenInfoPo.getAccessToken();
        this.refreshToken = tokenInfoPo.getRefreshToken();
        this.expiresIn = tokenInfoPo.getExpiresIn();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "TokenInfoVO{" + "accessToken='" + accessToken + '\'' + ", refreshToken='" + refreshToken + '\''
                + ", expiresIn=" + expiresIn + '}';
    }
}
