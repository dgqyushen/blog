package com.qian.controller;

import com.qian.pojo.Categories;
import com.qian.result.Result;
import com.qian.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getCategoriesData",method = RequestMethod.GET)
    public Map<String, Object> getCategoriesData(){
        List<Map<String, Object>> categoryData = categoriesService.getCategoryData();
        return Result.returnResult(200,"成功获取分类数据",categoryData);
    }

    @RequestMapping(value = "/insertCategory",method = RequestMethod.POST)
    public Map<String, Object> insertCategory(@RequestBody Categories categories){
//        System.out.println(categories);
        return Result.returnResult(200,"成功修改一条分类数据",categoriesService.editCategory(categories));
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public Map<String, Object> addCategory(@RequestBody Map<String, Object> map){
//        System.out.println(name);
//        System.out.println(map);
        return Result.returnResult(200,"成功添加一条分类数据",categoriesService.addCategory((String) map.get("name")));
    }

    @RequestMapping(value = "/getCategoryInfo", method = RequestMethod.GET)
    public Map<String, Object> getCategoryInfo(){
        return Result.returnResult(200,"成功获取所有分类数据",categoriesService.getCategoryInfo());
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.POST)
    public Map<String, Object> editCategory(@RequestBody Map<String, Object> postData){
        System.out.println(postData);
        return Result.returnResult(200,"成功修改分类数据",categoriesService.settingCategory(postData));
    }

    @RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.POST)
    public Map<String, Object> deleteCategory(@PathVariable int id){
        return Result.returnResult(200,"成功删除分类数据",categoriesService.deleteCategory(id));
    }

    @RequestMapping(value = "/getCategoriesList",method = RequestMethod.GET)
    public Map<String, Object> getCategoriesList(){
        return Result.returnResult(200,"获取分类表格",categoriesService.getCategoryList());
    }


}
