package com.qian.service;

import com.qian.dto.UserRoleDTO;
import com.qian.entity.User;

import java.util.List;

public interface UserService {
    User getUserByUserName(String userName,String password);

    Integer getUserNum();

    List<UserRoleDTO> getUserRoleData();

    int setUserLocked(int id);

    int setUserRole(int userId,String roleName);
}
