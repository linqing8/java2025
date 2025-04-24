package com.java2.basicAuth.bean;

import java.util.List;

public class RoleBean {

    private String role;
    private String rloleName;
    private List<ResourceBean> resources;

    public RoleBean() {
    }

    public RoleBean(String role, String rloleName) {
        this.role = role;
        this.rloleName = rloleName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRloleName() {
        return rloleName;
    }

    public void setRloleName(String rloleName) {
        this.rloleName = rloleName;
    }

    public List<ResourceBean> getResources() {
        return resources;
    }

    public void setResources(List<ResourceBean> resources) {
        this.resources = resources;
    }
}
