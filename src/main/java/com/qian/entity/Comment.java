package com.qian.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "comment")
public class Comment implements Serializable {
    @TableId(value = "comment_id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "comment_blog_id")
    private Integer blogId;
    @TableField(value = "comment_content")
    private String content;
    @TableField(value = "comment_date")
    private Date date;
    @TableField(value = "comment_author")
    private String author;
    @TableField(value = "comment_avatar")
    private String commentAvatar;
    @TableLogic
    private Integer commentDeleted;
}
