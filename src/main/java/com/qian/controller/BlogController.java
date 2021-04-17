package com.qian.controller;

import com.qian.pojo.Blog;
import com.qian.result.Result;
import com.qian.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public Map<String,Object> getBlog(){
        List<Blog> blogs = blogService.getAll();
        return Result.returnResult(200,"成功获取所以博客文章",blogs);
    }
    @RequestMapping(value = "getBlogNum",method = RequestMethod.GET)
    public Map<String,Object> getBlogNum(){
        return Result.returnResult(200,"成功获取博客数目",blogService.getAll().size());
    }

    @RequestMapping(value = "/searchContent",method = RequestMethod.GET)
    public List<Blog> getBlogBySearchContent(String content){
        return blogService.getBlogsByContent(content);
    }

    @RequestMapping(value = "/getLatestDay",method = RequestMethod.GET)
    public Date getBlogCreatedLatestDay(){
        return blogService.getBlogCreatedLatestDay();
    }

    @RequestMapping(value = "/getOneById",method = RequestMethod.GET)
    public Map<String,Object> getOneById(int id){
//        System.out.println(id);
//        return Result.returnResult(200,"获取当前id博客",blogService.getOneById(id));
        Blog blog = blogService.getOneById(id);
        HashMap<String, Object> map = new HashMap<>();
        HashMap<Object, Object> data = new HashMap<>();
        data.put("blog",blog);
        data.put("blogLength",blog.getBlogContent().length());
        map.put("code",200);
        map.put("msg","获取当前id博客");
        map.put("data",data);
        return map;
    }

}
