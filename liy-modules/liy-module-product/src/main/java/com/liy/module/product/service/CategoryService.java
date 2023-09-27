package com.liy.module.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liy.model.product.po.CategoryPo;
import com.liy.model.product.vo.CategoryTreeVo;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author liy
 * @since 2023-09-23
 */
public interface CategoryService extends IService<CategoryPo> {

    /**
     * @description: 根据父分类id返回商品子分类，树结构
     * @author: liy
     * @param:
     * @return:
     **/
    CategoryTreeVo getCategoryTreeById(Long categoryId);
}
