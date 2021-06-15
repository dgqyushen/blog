package com.qian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qian.dto.RolePermDTO;
import com.qian.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    Integer getRoleNum(String roleDescription);

    List<RolePermDTO> getAll();

    Integer insertRolePermission(Map<String, Object> map);
}
