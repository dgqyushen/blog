package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.mapper.UserMapper;
import com.qian.pojo.User;
import com.qian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName,String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_username",userName);
        User user = userMapper.selectOne(wrapper);
        if (user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public Integer getUserNum() {
        return userMapper.selectList(null).size();
    }
}
