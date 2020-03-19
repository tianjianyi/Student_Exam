package com.yifeng.service.impl;

import com.yifeng.dao.RoleDao;
import com.yifeng.dao.UserDao;
import com.yifeng.domain.Role;
import com.yifeng.domain.UserInfo;
import com.yifeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println("-------------");
        //System.out.println(username);
        UserInfo userInfo = userDao.findByUsername(username);
        userInfo.setRoles(roleDao.findRoleByUserId(userInfo.getRoldId()));
        //System.out.println(roleDao.findRoleByUserId(userInfo.getRoldId()));
        //System.out.println("-------------");
        //System.out.println(userInfo);
        //User user = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUserId(), "{noop}" + userInfo.getPASSWORD(), true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        //System.out.println("**********");
        for (Role role : roles) {
            //System.out.println(role.getRoleName());
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public UserInfo findByName(String name) {
        return userDao.findByUsername(name);
    }
}
