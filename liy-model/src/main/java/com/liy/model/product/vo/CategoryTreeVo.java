package com.liy.model.product.vo;

import com.liy.model.product.po.CategoryPo;
import lombok.Data;
import lombok.ToString;
import org.mapstruct.ap.shaded.freemarker.template.utility.StringUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiY
 * 商品分类，树结构
 */

@Data
@ToString
public class CategoryTreeVo {

    /**
     * 分类id
     */
    private Long catId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父分类id
     */
    private Long parentCid;

    /**
     * 层级
     */
    private Integer catLevel;

    private List<String> pathNames;

    /**
     * 子分类
     */
    private List<CategoryTreeVo> categories;


    public CategoryTreeVo(Long id){
//        创建根分类
        if(id == 0){
            this.catLevel = -1;
            this.name = "根分类";
        }
        this.catId = id;
        categories = new ArrayList<>();
        pathNames = new ArrayList<>();
    }

//    Po转TreeVo
    public CategoryTreeVo(CategoryPo categoryPo){
        this.catId = categoryPo.getCatId();
        this.name = categoryPo.getName();
        this.catLevel = categoryPo.getCatLevel();
        categories = new ArrayList<>();
        pathNames = new ArrayList<>();
    }

    public void setChildren(CategoryPo categoryPo){
        categories.add(new CategoryTreeVo(categoryPo));
    }

    public void setChildren(CategoryTreeVo category){
        if(category != null){
            category.getPathNames().add(this.name);
            categories.add(category);
        }
    }



}
