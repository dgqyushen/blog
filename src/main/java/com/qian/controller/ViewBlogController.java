package com.qian.controller;

import com.qian.result.Result;
import com.qian.service.ViewBlogService;
import com.qian.vo.ViewBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/viewBlog")
public class ViewBlogController {

    @Autowired
    private ViewBlogService viewBlogService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<ViewBlog> getAll(){
        return viewBlogService.getAll();
    }

    @RequestMapping(value = "/getNum",method = RequestMethod.GET)
    public Map<String,Object> getViewBlogNum(){
        return Result.returnResult(200,"成功获取文章数目",viewBlogService.getAll().size());
    }

}
