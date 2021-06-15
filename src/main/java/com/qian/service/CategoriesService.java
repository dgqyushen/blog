package com.qian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qian.entity.Categories;
import com.qian.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoriesService extends IService<Categories> {
    List<Categories> getCategoriesByBlogId(Integer blogId);
    List<String> getAll();
//    Map<String, Object> getCategoryData();
    List<Map<String, Object>> getCategoryData();
    int editCategory(Categories categories);
    int addCategory(String name);
    List<Category> getCategoryInfo();
    int settingCategory(Map<String, Object> map);
    int deleteCategory(int id);
    List<String> getCategoryList();
    int deleteCategories(int[] categories);
}
