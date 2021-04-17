package com.qian.controller;

import com.qian.pojo.Categories;
import com.qian.result.Result;
import com.qian.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @RequestMapping(value = "/getByBlogId",method = RequestMethod.GET)
    public Map<String, Object> getCategoriesByBlogId(Integer blogId){
        List<Categories> categoriesByBlogId = categoriesService.getCategoriesByBlogId(blogId);
        return Result.returnResult(200,"成功获取分类",categoriesByBlogId);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public Map<String, Object> getAll(){
        List<String> all = categoriesService.getAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("categoriesName",all);
        map.put("num",all.size());
        return Result.returnResult(200,"成功获取分类",map);
    }


}
