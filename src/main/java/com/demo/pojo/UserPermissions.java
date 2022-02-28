package com.demo.pojo;

public class UserPermissions {
    Integer id;
    Integer userId;
    String permissionId;
    String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserPermissions{" +
                "id=" + id +
                ", userId=" + userId +
                ", permissionId='" + permissionId + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public UserPermissions(){

    }
}
