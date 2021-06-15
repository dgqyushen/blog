package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qian.entity.Permission;
import com.qian.mapper.PermissionMapper;
import com.qian.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int savePermission(Map<String,Object> map) {
        String url = (String) map.get("permissionUrl");
        String description = (String) map.get("permissionDescription");
        String tag = url.substring(1);
        // 判断条件是否存在
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("permission_url",url);
        Permission permission = permissionMapper.selectOne(wrapper);
        if (permission == null){
            return permissionMapper.insert(new Permission(null,description,tag,url));
        }
        return permission.getPermissionId();

//        return permissionMapper.insert(new Permission(null,description,tag,url));
    }
}
