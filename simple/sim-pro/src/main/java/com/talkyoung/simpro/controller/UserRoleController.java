package com.talkyoung.simpro.controller;

import com.talkyoung.simcommon.CommonResult;
import com.talkyoung.simpojo.combinationEntity.UserPermissionCombination;
import com.talkyoung.simpro.service.UserRoleSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/userRole")
@RestController
public class UserRoleController {
    @Autowired
    UserRoleSV userRoleSV;

    @RequestMapping(value = "/getUserRolePermission/{userId}",method = RequestMethod.GET)
    public CommonResult<List<UserPermissionCombination>> getUserRolePermission(@PathVariable Integer userId){
        List<UserPermissionCombination> userRolePermission = userRoleSV.getUserRolePermission(userId);
        return CommonResult.success(userRolePermission);
    }
}
