package com.qian.controller;

import com.qian.pojo.User;
import com.qian.result.Result;
import com.qian.service.UserService;
import com.qian.vo.ViewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/getNum")
    public Map<String, Object> getUserNum(){
        return Result.returnResult(200,"获取用户数量",userService.getUserNum());
    }
}
