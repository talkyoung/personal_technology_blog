package com.talkyoung.ptbpro.service;

import com.talkyoung.ptbpojo.combinationEntity.UserPermissionCombination;

import java.util.List;

public interface UserRoleSV {
    List<UserPermissionCombination> getUserRolePermission(Integer userId);
}
