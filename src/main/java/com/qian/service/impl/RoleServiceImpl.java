package com.qian.service.impl;

import com.qian.dto.RolePermDTO;
import com.qian.mapper.RoleMapper;
import com.qian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<String> getAll() {
        ArrayList<String> roleList = new ArrayList<>();
        roleMapper.selectList(null).forEach(e -> roleList.add(e.getRoleDescription()));
        return roleList;
    }

    @Override
    public List<RolePermDTO> getRolePermList() {
        return roleMapper.getAll();
    }

    @Override
    public int saveRolePermission(int roleId, int permId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roleId",roleId);
        map.put("permId",permId);
        return roleMapper.insertRolePermission(map);
    }
}
