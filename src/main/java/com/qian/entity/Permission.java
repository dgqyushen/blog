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
@TableName(value = "permission")
public class Permission {
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer permissionId;
    @TableField(value = "permission_name")
    private String permissionName;
    @TableField(value = "permission_tag")
    private String permissionTag;
    @TableField(value = "permission_url")
    private String permissionUrl;
}
