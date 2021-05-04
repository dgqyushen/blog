package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.mapper.CommentMapper;
import com.qian.pojo.Comment;
import com.qian.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Comment> getCommentsByBlogId(int id) {
        String query = "blog_comment_list_"+id;
        List<Comment> redisComments = (List<Comment>) redisTemplate.opsForValue().get(query);
        if (redisComments!=null){
            return redisComments;
        }
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("comment_blog_id",id);
        List<Comment> comments = commentMapper.selectList(wrapper);
        redisTemplate.opsForValue().set(query,comments);
        return comments;
    }

    @Override
    public int saveComment(Comment comment) {
        Integer blogId = comment.getBlogId();
        String query = "blog_comment_list_"+blogId;
        ArrayList<Comment> redisComments = (ArrayList<Comment>) redisTemplate.opsForValue().get(query);
        redisComments.add(comment);
//        保存评论到redis
        redisTemplate.opsForValue().set(query,redisComments);
        return commentMapper.insert(comment);
    }

//    只给默认5条最新的评论
    @Override
    public List<Comment> getLatestComments() {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.orderByDesc("comment_date");
//        List<Comment> comments = commentMapper.selectList(commentQueryWrapper);
       return commentMapper.selectList(commentQueryWrapper).subList(0,5);
    }

    @Override
    public Integer getAllCommentsNum() {
        return commentMapper.selectList(null).size();
    }
}
