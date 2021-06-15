package com.qian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qian.dto.CommentDTO;
import com.qian.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    List<Comment> getCommentsByBlogId(int id);

    int saveComment(Comment comment);

    List<Comment> getLatestComments();

    Integer getAllCommentsNum();

    List<CommentDTO> getCommentData();

    int deleteComment(int id);

    int deleteComments(int[] commentsList);
}
