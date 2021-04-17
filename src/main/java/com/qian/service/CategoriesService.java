package com.qian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qian.pojo.Categories;

import java.util.List;

public interface CategoriesService extends IService<Categories> {
    List<Categories> getCategoriesByBlogId(Integer blogId);
    List<String> getAll();
}
