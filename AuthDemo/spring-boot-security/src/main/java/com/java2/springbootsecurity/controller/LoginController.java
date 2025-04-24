package com.java2.springbootsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/common/")
public class LoginController {

    @GetMapping("/getLoginUserByPrincipal")
    public String getLoginUserByPrincipal(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/getLoginUserByAuthentication")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @GetMapping("/username")
    public String currentUserNameSimple(HttpServletRequest request) {
        return request.getUserPrincipal().getName();
    }

    @PostMapping("/getLoginUser")
    public String getLoginUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
}
