package com.qian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "visit")
public class Visit {
    @TableId(value = "visit_id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "visit_date")
    private Date date;
    @TableField(value = "visit_num")
    private Integer visitNum;



}
