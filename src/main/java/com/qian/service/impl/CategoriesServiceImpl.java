package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.mapper.CategoriesMapper;
import com.qian.mapper.CategoryMapper;
import com.qian.entity.Categories;
import com.qian.entity.Category;
import com.qian.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;
import java.util.stream.IntStream;

@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements CategoriesService {

    @Autowired
    private CategoriesMapper categoriesMapper;

    @Autowired
    private CategoryMapper categoryMapper;

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

//    @Override
//    public Map<String, Object> getCategoryData() {
//        List<String> all = categoriesMapper.getAll();
//        HashMap<String, Object> map = new HashMap<>();
//        for (String s : all) {
//            QueryWrapper<Categories> wrapper = new QueryWrapper<>();
//            wrapper.eq("categories_name",s);
//            map.put(s,categoriesMapper.selectList(wrapper).size());
//        }
//        return map;
//    }


    @Override
    public List<Map<String, Object>> getCategoryData() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();

        List<String> all = categoriesMapper.getAll();

        // 对象遍历
        for (String s : all) {
            QueryWrapper<Categories> wrapper = new QueryWrapper<>();
            HashMap<String, Object> map = new HashMap<>();
            wrapper.eq("categories_name",s);
            map.put("name",s);
            map.put("num",categoriesMapper.selectList(wrapper).size());
            list.add(map);
        }
        return list;
    }

    @Override
    public int editCategory(Categories categories) {
        QueryWrapper<Categories> categoriesQueryWrapper = new QueryWrapper<>();
        categoriesQueryWrapper.eq("categories_blog_id",categories.getBlogId());
        Categories categories1 = categoriesMapper.selectOne(categoriesQueryWrapper);
        if (categories1 == null){
            return categoriesMapper.insert(categories);
        }
        return categoriesMapper.update(categories, new QueryWrapper<Categories>().eq("categories_blog_id", categories.getBlogId()));
    }

    @Override
    public int addCategory(String name) {
        if (name==null||name.length()==0){
            return -1;
        }
        return categoryMapper.insert(new Category(null,name,new Date(System.currentTimeMillis()),0));
    }

    @Override
    public List<Category> getCategoryInfo() {
        return categoryMapper.selectList(null);
    }

    @Override
    public int settingCategory(Map<String, Object> map) {
        String name = (String) map.get("name");
        int id = (int) map.get("id");
        Category category = new Category();
        category.setCategoryId(id);
        category.setCategoryName(name);
        return categoryMapper.updateById(category);
    }

    @Override
    public int deleteCategory(int id) {
        return categoryMapper.deleteById(id);
    }

    @Override
    public List<String> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    @Override
    public int deleteCategories(int[] categories) {
        IntStream stream = Arrays.stream(categories);
        stream.forEach(this::deleteCategory);
        return 0;
    }
}
