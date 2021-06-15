package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.dto.UserRoleDTO;
import com.qian.entity.Permission;
import com.qian.mapper.RoleMapper;
import com.qian.mapper.UserMapper;
import com.qian.entity.User;
import com.qian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService,UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;



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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userMapper.findByUsername(username);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_username",username);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null){
            return null;
        }
        List<Permission> userPermissionsList = userMapper.findAllPermissions(username);
        ArrayList<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        userPermissionsList.forEach(e->{
           grantedAuthorityList.add(new SimpleGrantedAuthority(e.getPermissionTag()));
        });
        user.setAuthorities(grantedAuthorityList);
        return user;
    }

    @Override
    public List<UserRoleDTO> getUserRoleData() {
        return userMapper.getUserRoleData();
    }

    @Override
    public int setUserLocked(int id) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_id", id));
        if (user==null){
            return -1;
        }
        user.setIsLocked(!user.getIsLocked());
        return userMapper.updateById(user);
    }

    @Override
    public int setUserRole(int userId, String roleName) {
        Integer roleNum = roleMapper.getRoleNum(roleName);
        if (roleNum == null){

            return -1;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("roleId",roleNum);
        return userMapper.setUserRole(map);



    }
}
