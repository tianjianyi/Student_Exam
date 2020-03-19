package com.yifeng.domain;

import java.util.List;

public class UserInfo {
    private Integer id;
    private String userId;
    private String PASSWORD;
    private Integer roldId;
    List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Integer getRoldId() {
        return roldId;
    }

    public void setRoldId(Integer roldId) {
        this.roldId = roldId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", roldId=" + roldId +
                ", roles=" + roles +
                '}';
    }
}
