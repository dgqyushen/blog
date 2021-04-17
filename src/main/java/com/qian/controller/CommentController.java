package com.qian.controller;

import com.qian.pojo.Comment;
import com.qian.result.Result;
import com.qian.service.CommentService;
import com.qian.vo.ViewComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Comment> getCommentByBlogId(@PathVariable int id){
        return commentService.getCommentsByBlogId(id);
    }



//    @RequestMapping(value = "/add")
//    public String saveComment(ViewComment viewComment){
////        System.out.println(comment);
////        System.out.println(viewComment.toString());
////        return new HashMap<String,Object>();
////        httpRequest.
//        System.out.println(viewComment.toString());
//        return "123";
//    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String saveComment(@RequestBody ViewComment viewComment){
//        System.out.println(viewComment.toString());
//        return "123";
        Date date = new Date(System.currentTimeMillis());
//        后期添加头像功能
        commentService.saveComment(new Comment(null,viewComment.getCommentBlogId(),viewComment.getCommentContent(),date,viewComment.getCommentAuthor(),null));
        return "succeed";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Map<String, Object> getLatestComments(){
        List<Comment> list = commentService.getLatestComments();
        return Result.returnResult(200,"成功获取最新的5条评论数据",list);
    }




}
