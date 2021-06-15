package com.qian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Integer commentId;
    private String commentContent;
    private Date commentDate;
    private String commentAuthor;
    private String commentAvatar;
    private String blogTitle;
}
