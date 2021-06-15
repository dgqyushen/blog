package com.qian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qian.dto.UserRoleDTO;
import com.qian.entity.Permission;
import com.qian.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    User findByUsername(String username);

    List<Permission> findAllPermissions(String username);

    List<UserRoleDTO> getUserRoleData();

    int setUserRole(Map<String,Object> map);
}
