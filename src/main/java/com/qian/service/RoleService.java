package com.qian.service;

import com.qian.dto.RolePermDTO;
import com.qian.entity.Role;

import java.util.List;

public interface RoleService {
    List<String> getAll();

    List<RolePermDTO> getRolePermList();

    int saveRolePermission(int roleId, int permId);
}
