package com.demo.pojo;

public class AdminPermissions {
    Integer id;
    Integer adminId;
    String permissionId;
    String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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
        return "AdminPermissions{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", permissionId='" + permissionId + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
    public AdminPermissions(){

    }
}
