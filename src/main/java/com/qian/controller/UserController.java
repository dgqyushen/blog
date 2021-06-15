package com.qian.controller;

import com.qian.entity.User;
import com.qian.result.Result;
import com.qian.service.UserService;
import com.qian.vo.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public Map<String, Object> login(@RequestBody ViewUser viewUser){
        System.out.println(viewUser);
        User user = userService.getUserByUserName(viewUser.getUsername(), viewUser.getPassword());
        if (user==null){
            return Result.returnResult(404,"没有这个用户","");
        }
        return Result.returnResult(200,"",user);
    }

    @RequestMapping(value = "/getNum",method = RequestMethod.GET)
    public Map<String, Object> getUserNum(){
        return Result.returnResult(200,"获取用户数量",userService.getUserNum());
    }

    @RequestMapping(value = "/getUserRoleData",method = RequestMethod.GET)
    public Map<String, Object> getUserRoleData(){
        return Result.returnResult(200,"获取用户角色数据",userService.getUserRoleData());
    }

    @RequestMapping(value = "/setUserLocked",method = RequestMethod.POST)
    public Map<String, Object> setUserLocked(@RequestBody Map<String, Object> postData){
        return Result.returnResult(200,"成功设置用户锁定",userService.setUserLocked((Integer) postData.get("id")));
    }

    @RequestMapping(value = "/setUserInfo",method = RequestMethod.POST)
    public Map<String, Object> setUserInfo(@RequestBody Map<String, Object> postData){
        System.out.println(postData);
        Integer userId = (Integer) postData.get("userId");
        String role = (String) postData.get("role");
        return Result.returnResult(200,"成功修改用户信息",userService.setUserRole(userId,role));
    }


}
