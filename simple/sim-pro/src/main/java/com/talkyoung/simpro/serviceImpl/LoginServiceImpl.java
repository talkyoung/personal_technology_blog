package com.talkyoung.simpro.serviceImpl;

import com.talkyoung.simpojo.mapper.UserMapper;
import com.talkyoung.simpojo.entity.User;
import com.talkyoung.simpojo.entity.UserExample;
import com.talkyoung.simpro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsService userDetailsService;
    @Override
    public User findUserByName(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0){
            return null;
        }
        return users.get(0);
    }

    @Override
    public UserDetails login(String username, String password) {
        UserDetails userDetails = null;
        //密码需要客户端加密后传递
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return userDetails;
        } catch (AuthenticationException e) {
            return null;
        }
    }
}
