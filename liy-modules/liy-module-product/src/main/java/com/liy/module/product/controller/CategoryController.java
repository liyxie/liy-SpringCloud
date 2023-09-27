package com.liy.module.product.controller;

import com.liy.common.core.web.controller.BaseController;
import com.liy.common.core.web.domain.AjaxResult;
import com.liy.model.product.vo.CategoryTreeVo;
import com.liy.module.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author liy
 * @since 2023-09-23
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    /**
     * @description: 获取id为父分类的商品分类信息,
     * @author: liy
     * @param:  分类的父id
     * @return:
     **/
    @GetMapping("/tree")
    public AjaxResult list(@RequestParam Long categoryId){

        CategoryTreeVo categoryTreeVo = categoryService.getCategoryTreeById(categoryId);

        List<String> list = new ArrayList<String>();
        return toAjaxResult("categorTree", categoryTreeVo);
    }


}
