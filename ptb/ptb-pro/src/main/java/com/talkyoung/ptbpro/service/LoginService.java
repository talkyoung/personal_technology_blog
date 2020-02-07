package com.talkyoung.ptbpro.service;

import com.talkyoung.ptbpojo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService {

    User findUserByName(String username);

    UserDetails login(String username, String password);
}
