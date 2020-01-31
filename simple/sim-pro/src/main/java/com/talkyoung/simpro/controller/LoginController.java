package com.talkyoung.simpro.controller;

import com.talkyoung.simcommon.CommonResult;
import com.talkyoung.simpojo.entity.User;
import com.talkyoung.simpro.component.UserDetailsImpl;
import com.talkyoung.simpro.service.LoginService;
import com.talkyoung.simpro.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public CommonResult login(@RequestParam String username, @RequestParam String password){
    public CommonResult login(@RequestBody User user){
        UserDetailsImpl userDetails = (UserDetailsImpl)loginService.login(user.getUsername(), user.getPassword());
        if (userDetails == null) {
            return CommonResult.validateFailed("用户名或密码错误!");
        }
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        tokenMap.put("userId",userDetails.getUser().getId().toString());
        return CommonResult.success(tokenMap);
    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public Result login(@RequestParam String username, @RequestParam String password){
//        User user = loginService.findUserByName(username);
//        boolean notEmpty = StringUtils.isNotEmpty(user.getPassword());
//        if(notEmpty && user.getPassword().equals(password)){
//            return ResultFactory.buildSuccessResult(null);
//        }
//        return ResultFactory.buildFailResult("登录失败");
//    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
