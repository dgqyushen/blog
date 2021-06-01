package com.qian.controller;

import com.qian.pojo.Blog;
import com.qian.result.Result;
import com.qian.service.BlogService;
import com.qian.vo.ViewBlogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Arrays;
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

    @RequestMapping(value = "/getBlogData",method = RequestMethod.GET)
    public Map<String, Object> getLatestFiveBlogsNameAndVisNum(){
        List<Blog> blogData = blogService.getLatestFiveBlogsNameAndVisNum();
        System.out.println(blogData);
        return Result.returnResult(200,"成功获取博客数据",blogData);
    }

    @RequestMapping(value = "/addBlog", method = RequestMethod.POST)
    public Map<String, Object> addBlog(@RequestBody ViewBlogs viewBlogs){
        blogService.saveBlog(viewBlogs);
//        System.out.println(viewBlogs);
        return Result.returnResult(200,"成功接收信息","");
    }

    @RequestMapping(value = "/getBlogInfo",method = RequestMethod.GET)
    public Map<String, Object> getBlogInfo(){
        return Result.returnResult(200,"成功获取博客信息",blogService.getBlogsInfo());
    }

    @RequestMapping(value = "/setBlogTop",method = RequestMethod.POST)
    public Map<String, Object> setBlogTop(@RequestBody ViewBlogs viewBlogs){
        return Result.returnResult(200,"成功修改博客置顶",blogService.changeBlogTopByBlogId(viewBlogs.getIsTop(),viewBlogs.getId()));
    }

    @RequestMapping(value = "/deleteBlog/{blogId}", method = RequestMethod.POST)
    public Map<String, Object> deleteBlogById(@PathVariable Integer blogId){
//        System.out.println(blogId);
        return Result.returnResult(200,"成功删除博客",blogService.deleteBlogById(blogId));
    }

    @RequestMapping(value = "/updateBlog",method = RequestMethod.POST)
    public Map<String, Object> updateBlogById(@RequestBody ViewBlogs viewBlogs){
//        System.out.println(viewBlogs);
        return Result.returnResult(200,"成功更新博客",blogService.updateBlog(viewBlogs));
    }

    @RequestMapping(value = "/deleteBlogs", method = RequestMethod.POST)
    public Map<String, Object> deleteBlogsById(@RequestBody int[] blogIdList){
//        System.out.println(Arrays.toString(blogIdList));
        return Result.returnResult(200,"成功删除博客",blogService.deleteBlogsById(blogIdList));
    }


}
