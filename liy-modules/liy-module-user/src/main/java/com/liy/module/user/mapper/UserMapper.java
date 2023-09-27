package com.liy.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liy.model.user.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author liy
 * @since 2023-09-04
 */

@Mapper
public interface UserMapper extends BaseMapper<UserPo> {

}
