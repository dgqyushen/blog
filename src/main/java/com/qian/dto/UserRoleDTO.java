package com.qian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {
    private Integer userId;
    private String userUserName;
    private String userAvatar;
    private Date userCreatedDate;
    private String userLoginIP;
    private String userLoginLocation;
    private Boolean userLocked;
    private Date userLastLogin;
    private String roleDescription;
}
