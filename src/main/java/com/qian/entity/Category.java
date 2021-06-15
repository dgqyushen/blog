package com.qian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;
    @TableField(value = "category_name")
    private String categoryName;
    @TableField(value = "category_created_date")
    private Date categoryCreatedDate;
    @TableLogic
    private Integer categoryDeleted;
}
