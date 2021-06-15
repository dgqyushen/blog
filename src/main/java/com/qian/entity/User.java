package com.qian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User implements Serializable, UserDetails {
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "user_username")
    private String username;
    @TableField(value = "user_password")
    private String password;
    @TableField(value = "user_created_date")
    private Date createdDate;
    @TableField(value = "user_last_login")
    private Date lastLogin;
    @TableField(value = "user_avatar")
    private String avatar;
    @TableField(value = "user_login_ip")
    private String loginIp;
    @TableField(value = "user_login_location")
    private String loginLocation;
    @TableField(value = "user_locked")
    private Boolean isLocked;

    // security中对应的权限
    @TableField(exist = false)
    private List<GrantedAuthority> authorities = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
