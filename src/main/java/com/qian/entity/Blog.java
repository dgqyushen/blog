package com.qian.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog")
public class Blog implements Serializable {
    @TableId(value = "blog_id",type = IdType.AUTO)
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
    private Boolean blogTop;
    @TableField(value = "blog_visit_num")
    private Integer blogVisitNum;
    @TableField(exist = false)
    private String categoriesName;
    @TableField(exist = false)
    private List<String> tags;
    @TableField(exist = false)
    private Integer likeNum;
    @TableField(exist = false)
    private Integer visitNum;
    @TableLogic
    private Integer blogDeleted;

}
