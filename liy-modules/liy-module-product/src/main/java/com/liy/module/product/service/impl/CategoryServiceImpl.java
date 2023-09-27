package com.liy.module.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liy.common.core.util.StringUtils;
import com.liy.model.product.po.CategoryPo;
import com.liy.model.product.vo.CategoryTreeVo;
import com.liy.module.product.mapper.CategoryMapper;
import com.liy.module.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author liy
 * @since 2023-09-23
 */
@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryPo> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryTreeVo getCategoryTreeById(Long categoryId) {
        // 检查id
        categoryId = categoryId < 0? 0:categoryId;

        List<CategoryPo> categoryPoList;

        // 查询全部子分类
        if(categoryId != 0){
            categoryPoList = categoryMapper.selectListById(categoryId);
        }else {
            LambdaQueryWrapper<CategoryPo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(CategoryPo::getShowStatus,1);
            categoryPoList = categoryMapper.selectList(queryWrapper);
        }
        CategoryTreeVo root;
        // 树结构组装
        if(categoryId == 0){
            root = new CategoryTreeVo(categoryId);
            recursionCategory(categoryPoList, root);
        }else {
            root = recursionCategory(categoryPoList, categoryId);
        }
        log.info(root.toString());
        return root;
    }

    // 递归组装树结构
    private CategoryTreeVo recursionCategory(List<CategoryPo> categoryPoList, CategoryTreeVo root) {

        List<CategoryTreeVo> treeVos = categoryPoList.stream()
                .filter(categoryPo ->{
                    return categoryPo.getParentCid() == root.getCatId();
                })
                .map((categoryPo) -> {
                    root.setChildren( recursionCategory(categoryPoList, new CategoryTreeVo(categoryPo)) );
                    return root;
                })
                .collect(Collectors.toList());

//        root.setChildren(treeVos);
        return root;
    }

    // 递归组装树结构
    private CategoryTreeVo recursionCategory(List<CategoryPo> categoryPoList, Long id) {
        CategoryPo rootPo = categoryPoList.stream().filter((categoryPo -> categoryPo.getCatId() == id)).findAny().orElse(null);
        if(StringUtils.isNull(rootPo)){
            return new CategoryTreeVo(0L);
        }
        CategoryTreeVo root = new CategoryTreeVo(rootPo);
        recursionCategory(categoryPoList, root);
        return root;
    }




}
