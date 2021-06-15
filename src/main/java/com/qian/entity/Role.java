package com.qian.entity;

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
@TableName(value = "role")
public class Role {
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;
    @TableField(value = "role_name")
    private String roleName;
    @TableField(value = "role_description")
    private String roleDescription;
}
