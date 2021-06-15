package com.qian.controller;

import com.qian.result.Result;
import com.qian.service.PermissionService;
import com.qian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/saveRolePermission",method = RequestMethod.POST)
    public Map<String, Object> saveRolePermission(@RequestBody Map<String, Object> postData){
//        System.out.println(postData);
        HashMap<String, Object> map = new HashMap<>();
        map.put("permissionDescription",postData.get("permissionDescription"));
        map.put("permissionUrl",postData.get("permissionUrl"));
        int i = permissionService.savePermission(map);
//        System.out.println("permId==>"+i);
//        System.out.println("roleId===>"+postData.get("roleId"));
        return Result.returnResult(200,"插入角色与权限关系成功",roleService.saveRolePermission((Integer) postData.get("roleId"),i));
//        return Result.returnResult(200,"插入角色与权限关系成功",1);
    }

//)

}
