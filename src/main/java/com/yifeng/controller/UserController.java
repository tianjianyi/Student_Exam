package com.yifeng.controller;

import com.yifeng.domain.User;
import com.yifeng.domain.UserInfo;
import com.yifeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    public String login(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String name = userDetails.getUsername();
        UserInfo userInfo =  userService.findByName(name);
        //System.out.println(userInfo);
        if(userInfo.getRoldId() == 0)
            return "admin/main";
        if(userInfo.getRoldId() == 1)
            return "student/main";
        if(userInfo.getRoldId() == 2)
            return "teacher/main";
        return "";
    }
}
