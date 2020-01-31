package com.talkyoung.simpro.component;

import com.talkyoung.simpojo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    private User user;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(User user) {
        this.user = user;
        authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 账号是否未过期，默认是false
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账号是否未锁定，默认是false
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 账号凭证是否未过期，默认是false
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
