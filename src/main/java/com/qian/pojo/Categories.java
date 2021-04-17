package com.qian.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
}
