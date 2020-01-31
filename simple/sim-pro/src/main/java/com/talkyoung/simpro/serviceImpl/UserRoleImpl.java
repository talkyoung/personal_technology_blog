package com.talkyoung.simpro.serviceImpl;

import com.talkyoung.simpojo.combinationEntity.UserPermissionCombination;
import com.talkyoung.simpojo.mapper.UserPermissionMapper;
import com.talkyoung.simpojo.entity.UserPermission;
import com.talkyoung.simpro.dao.UserPermissionDao;
import com.talkyoung.simpro.service.UserRoleSV;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author talkyoung
 */
@Service
public class UserRoleImpl implements UserRoleSV {

    @Autowired
    private UserPermissionDao userPermissionDao;

    /**
     * 根据用户Id获取该用户所拥有的权限（即菜单）
     * @param userId
     * @return
     */
    @Override
    public List<UserPermissionCombination> getUserRolePermission(Integer userId) {
        List<UserPermission> userPermissionList = userPermissionDao.getUserRolePermissionByUserId(userId);
        List<UserPermissionCombination> result = userPermissionList.stream()
                .filter(permission -> permission.getPid().equals(0L))
                .map(permission -> covert(permission,userPermissionList)).collect(Collectors.toList());
        return result;
    }

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    private UserPermissionCombination covert(UserPermission permission,List<UserPermission> permissionList){
        UserPermissionCombination node = new UserPermissionCombination();
        BeanUtils.copyProperties(permission,node);
        List<UserPermissionCombination> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getId()))
                .map(subPermission -> covert(subPermission,permissionList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
