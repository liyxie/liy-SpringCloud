package com.liy.module.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liy.model.product.po.CategoryPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author liy
 * @since 2023-09-23
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryPo> {

    /**
     * @description: 查询子分类，
     * @author: liy
     * @param:
     * @return:
     **/
    List<CategoryPo> selectListById(@Param("cat_id") Long categoryId);
}
