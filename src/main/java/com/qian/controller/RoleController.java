package com.qian.controller;

import com.qian.result.Result;
import com.qian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/getAllRoleDescriptions",method = RequestMethod.GET)
    public Map<String, Object> getAllRoleDescriptions(){
        return Result.returnResult(200,"成功获取角色列表",roleService.getAll());
    }

    @RequestMapping(value = "/getRolePermissionData",method = RequestMethod.GET)
    public Map<String, Object> getRolePermissionData(){
        return Result.returnResult(200,"成功获取角色权限数据",roleService.getRolePermList());
    }



}
