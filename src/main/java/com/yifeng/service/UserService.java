package com.yifeng.service;


import com.yifeng.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserInfo findByName(String name);
}
