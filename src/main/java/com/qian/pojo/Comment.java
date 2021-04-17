package com.qian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private String avatar;
}
