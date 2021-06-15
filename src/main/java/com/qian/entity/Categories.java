package com.qian.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "categories")
public class Categories {
    @TableId(value = "categories_id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "categories_blog_id")
    private Integer blogId;
    @TableField(value = "categories_name")
    private String name;
    @TableLogic
    private Integer categoriesDeleted;
}
