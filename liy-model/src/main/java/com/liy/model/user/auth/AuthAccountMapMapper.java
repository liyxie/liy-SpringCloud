package com.liy.model.user.auth;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author LiY
 */

@Mapper
public interface AuthAccountMapMapper {

    AuthAccountMapMapper INSTANCE = Mappers.getMapper(AuthAccountMapMapper.class);

    AuthAccountInfoPo toInfoPo(AuthAccountBo authAccountBo);


}
