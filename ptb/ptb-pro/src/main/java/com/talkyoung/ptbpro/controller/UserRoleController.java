package com.talkyoung.ptbpro.controller;

import com.talkyoung.ptbcommon.CommonResult;
import com.talkyoung.ptbpojo.combinationEntity.UserPermissionCombination;
import com.talkyoung.ptbpro.service.UserRoleSV;
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
