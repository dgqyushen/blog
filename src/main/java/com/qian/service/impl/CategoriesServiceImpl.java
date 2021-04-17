package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.mapper.CategoriesMapper;
import com.qian.pojo.Categories;
import com.qian.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements CategoriesService {

    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public List<Categories> getCategoriesByBlogId(Integer blogId) {
        QueryWrapper<Categories> wrapper = new QueryWrapper<>();
        wrapper.eq("categories_blog_id",blogId);
        List<Categories> categories = categoriesMapper.selectList(wrapper);
        return categories;
    }

    @Override
    public List<String> getAll() {
        return categoriesMapper.getAll();
    }
}
