package com.liy.model.user;

import com.liy.model.user.po.UserPo;
import com.liy.model.user.vo.UserInfoVo;
import com.liy.model.user.vo.UserSimpleInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @Author LiY
 */

@Mapper
public interface UserMapMapper {

    UserMapMapper INSTANCE = Mappers.getMapper(UserMapMapper.class);

    UserInfoVo toUserInfoVo(UserPo userPo);


    UserSimpleInfoVO toUserSimpleInfoVO(UserInfoVo userInfoVo);

}
