package com.liy.auth.test;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author LiY
 */

@Mapper
public interface MapMapper {

    MapMapper m = Mappers.getMapper(MapMapper.class);

    Vo to(Po po);
}
