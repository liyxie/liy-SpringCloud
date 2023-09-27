package com.liy.model.user.auth.token;

import com.liy.model.user.auth.AuthAccountInfoPo;

import java.io.Serializable;

/**
 * token信息，该信息存在redis中
 *
 * @author lyi
 */
public class TokenInfoPo implements Serializable {

	/**
	 * 保存在token信息里面的用户信息
	 */
	private AuthAccountInfoPo userInfoIn;

	private String accessToken;

	private String refreshToken;

	/**
	 * 在多少秒后过期
	 */
	private Long expiresIn;

	public AuthAccountInfoPo getUserInfoInToken() {
		return userInfoIn;
	}

	public void setUserInfoInToken(AuthAccountInfoPo userInfoInToken) {
		this.userInfoIn = userInfoInToken;
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
		return "TokenInfoBO{" + "userInfoInToken=" + userInfoIn + ", accessToken='" + accessToken + '\''
				+ ", refreshToken='" + refreshToken + '\'' + ", expiresIn=" + expiresIn + '}';
	}

}
