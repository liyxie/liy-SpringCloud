package com.liy.common.security;

import com.liy.model.user.auth.AuthAccountInfoPo;

/**
 * @author FrozenWatermelon
 * @date 2020/7/16
 */
public class AuthUserContext {

	/** The request holder. */
	private static final ThreadLocal<AuthAccountInfoPo> USER_INFO_IN_TOKEN_HOLDER = new ThreadLocal<>();

	public static AuthAccountInfoPo get() {
		return USER_INFO_IN_TOKEN_HOLDER.get();
	}


	public static AuthAccountInfoPo forceGet() {
		return USER_INFO_IN_TOKEN_HOLDER.get();
	}

	public static void set(AuthAccountInfoPo userInfoInTokenBo) {
		USER_INFO_IN_TOKEN_HOLDER.set(userInfoInTokenBo);
	}

	public static void clean() {
		if (USER_INFO_IN_TOKEN_HOLDER.get() != null) {
			USER_INFO_IN_TOKEN_HOLDER.remove();
		}
	}

}
