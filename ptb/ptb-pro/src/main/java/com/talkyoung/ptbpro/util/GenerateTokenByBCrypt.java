package com.talkyoung.ptbpro.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateTokenByBCrypt {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @RequestMapping(value = "/generateToken",method = RequestMethod.GET)
    public void generateToken(String username,String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = null;
        if(userDetails!=null){
            token = jwtTokenUtil.generateToken(userDetails);
            System.out.println("user(admin) token:"+ token);
        }else{
            System.out.println("无法在数据库中查找到用户"+username);
        }
        String artificialPwd = password;
        String generatePwdEncry = passwordEncoder.encode(artificialPwd);
        System.out.println("pws(111111) encryp:"+ generatePwdEncry);
    }
}
