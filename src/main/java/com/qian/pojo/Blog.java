package com.qian.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog")
public class Blog implements Serializable {
    @TableId(value = "blog_id")
    private Integer blogId;
    @TableField(value = "blog_title")
    private String blogTitle;
    @TableField(value = "blog_content")
    private String blogContent;
    @TableField(value = "blog_created")
    private Date blogCreated;
    @TableField(value = "blog_modified")
    private Date blogModified;
    @TableField(value = "blog_image")
    private String blogImage;
    @TableField(value = "blog_author")
    private String blogAuthor;
    @TableField(value = "blog_top")
    private Boolean isTop;
}
