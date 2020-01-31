package com.talkyoung.simpro.service;

import com.talkyoung.simpojo.combinationEntity.UserPermissionCombination;

import java.util.List;

public interface UserRoleSV {
    List<UserPermissionCombination> getUserRolePermission(Integer userId);
}
