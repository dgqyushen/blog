package com.qian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qian.pojo.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    List<Comment> getCommentsByBlogId(int id);

    int saveComment(Comment comment);

    List<Comment> getLatestComments();

    Integer getAllCommentsNum();
}
