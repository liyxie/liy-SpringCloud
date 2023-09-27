package com.liy.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liy.model.user.auth.AuthAccountBo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 统一账户信息 Mapper 接口
 * </p>
 *
 * @author liy
 * @since 2023-09-07
 */
@Mapper
public interface AuthAccountMapper extends BaseMapper<AuthAccountBo> {

}
