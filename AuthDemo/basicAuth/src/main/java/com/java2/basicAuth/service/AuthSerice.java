package com.java2.basicAuth.service;


import com.java2.basicAuth.bean.UserBean;
import com.java2.basicAuth.util.TestData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class AuthSerice {

    private final String demoUserName = "admin";
    private final String demoUserPass = "admin";

    @Resource
    private TestData testData;

    public UserBean userLogin(UserBean user) {
        UserBean queryUser = testData.queryUser(user);
        if (queryUser != null) {
            queryUser.setUserId(UUID.randomUUID().toString());
        }
        return queryUser;
    }
}
