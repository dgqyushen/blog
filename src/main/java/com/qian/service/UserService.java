package com.qian.service;

import com.qian.pojo.User;

public interface UserService {
    User getUserByUserName(String userName,String password);
}
