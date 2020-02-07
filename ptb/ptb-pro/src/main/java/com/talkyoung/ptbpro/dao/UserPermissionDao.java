package com.talkyoung.ptbpro.dao;

import com.talkyoung.ptbpojo.entity.UserPermission;

import java.util.List;

public interface UserPermissionDao {
    //根据用户id查询角色对应的权限
    List<UserPermission> getUserRolePermissionByUserId(Integer userId);
}
