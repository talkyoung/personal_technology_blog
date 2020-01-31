package com.talkyoung.simpro.service;

import com.talkyoung.simpojo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.ws.ServiceMode;

public interface LoginService {

    User findUserByName(String username);

    UserDetails login(String username, String password);
}
