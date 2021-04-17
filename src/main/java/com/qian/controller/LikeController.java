package com.qian.controller;

import com.qian.result.Result;
import com.qian.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/likeNum")
public class LikeController {

    @Autowired
    private LikeService likeService;


    @RequestMapping(value = "/{blogId}",method = RequestMethod.POST)
    public Map<String, Object> likeNumAdd(@PathVariable int blogId){
        return Result.returnResult(200,"点赞加一",likeService.likeNumAdd(blogId));
    }

    @RequestMapping(value = "/{blogId}",method = RequestMethod.DELETE)
    public Map<String, Object> likeNumReduce(@PathVariable int blogId){
        return Result.returnResult(200,"取消点赞加一",likeService.likeNumReduce(blogId));
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public int getLikeNumByBlogId(int blogId){
        int num = likeService.getLikeNumByBlogId(blogId);
        return num;
    }

}
