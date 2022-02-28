package com.demo.pojo;

public class Permissions {
    Integer id;
    String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
    public Permissions(){

    }
}
