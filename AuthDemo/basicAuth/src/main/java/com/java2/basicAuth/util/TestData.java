package com.java2.basicAuth.util;

import com.java2.basicAuth.bean.ResourceBean;
import com.java2.basicAuth.bean.RoleBean;
import com.java2.basicAuth.bean.UserBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestData {
    private List<UserBean> allUsers;

    private List<UserBean> getAllUsers(){
        if(null == allUsers){
            allUsers = new ArrayList<>();

            ResourceBean mobileResource = new ResourceBean("1","mobile");
            ResourceBean salaryResource = new ResourceBean("2","salary");
            List<ResourceBean> adminResources = new ArrayList<>();
            adminResources.add(mobileResource);
            adminResources.add(salaryResource);

            List<ResourceBean> managerResources = new ArrayList<>();
            managerResources.add(salaryResource);

            RoleBean adminRole = new RoleBean("1","mobile");
            adminRole.setResources(adminResources);
            RoleBean managerRole = new RoleBean("2","salary");
            managerRole.setResources(managerResources);
            List<RoleBean> adminRoles = new ArrayList<>();
            adminRoles.add(adminRole);
            List<RoleBean> managerRoles = new ArrayList<>();
            managerRoles.add(managerRole);

            UserBean user1 = new UserBean("1","admin","admin");
            user1.setUserRoles(adminRoles);
            user1.setResourceBeans(adminResources);
            UserBean user2 = new UserBean("2","manager","manager");
            user2.setUserRoles(managerRoles);
            user2.setResourceBeans(managerResources);
            UserBean user3 = new UserBean("3","worker","worker");

            allUsers.add(user1);
            allUsers.add(user2);
            allUsers.add(user3);
        }
        return allUsers;
    };

    public UserBean queryUser(UserBean user) {
        List<UserBean> allUsers = this.getAllUsers();
        List<UserBean> userList = allUsers.stream().filter(userBean ->
                userBean.getUserName().equals(user.getUserName())
                        && userBean.getUserPass().equals(user.getUserPass())
        ).collect(Collectors.toList());

        return userList.size()>0?userList.get(0):null;

    }
}
