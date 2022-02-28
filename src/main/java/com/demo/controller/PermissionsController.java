package com.demo.controller;

import com.demo.common.Msg;
import com.demo.mapper.UserPermissionMapper;
import com.demo.pojo.AdminPermissions;
import com.demo.pojo.Permissions;
import com.demo.pojo.UserPermissions;
import com.demo.service.AdminPermissionsService;
import com.demo.service.PermissionsService;
import com.demo.service.UserPermissionsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
//后台权限管理模块
public class PermissionsController {
    @Autowired
    private PermissionsService permissionsService;
    @Autowired
    private UserPermissionsService userPermissionsService;
    @Autowired
    private AdminPermissionsService adminPermissionsService;

    //找到当前全体用户拥有的权限，将查找出来的实体的permissions元素，装换成string类型的数组，并向前台传送数据
    @RequestMapping("/admin/permission/toUserPermissions.html")
    public String selectUserPermissionsAll(Model model) {
        List<UserPermissions> list = userPermissionsService.selectUserPermissionsAll();
        List<String> permissionsList = list.stream().map(UserPermissions::getPermission).collect(Collectors.toList());
        //PageInfo<Permissions> pageInfo=new PageInfo<Permissions>(list);
        model.addAttribute("permissionsList", permissionsList);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "permissionActive");
        model.addAttribute("activeUrl2", "userPermissionsActive");
        //model.addAttribute("username","username");
        return "admin/permission/userpermissions";
    }

    //更新权限功能，将前台传回来的string类型的数据，通过split方法分割成string类型数组
    //通过permissionsService中的方法得到所有回传回来的权限元组
    //获取其id通过增强for循环对数据库中用户的权限进行修改
    @RequestMapping("/admin/updateUserPermissions")
    @ResponseBody
    public Msg UserPermissions(@RequestParam("userPermissions") String userPermission) {
        String[] strings = userPermission.split(";");
        //得到允许的所有项目
        List<Permissions> list = permissionsService.selectPermissionsAll(strings);
        List<Integer> permissionsList = list.stream().map(Permissions::getId).collect(Collectors.toList());
        //状态设为0
        //循环updata状态为1
        System.out.println(permissionsList);
        userPermissionsService.updateUserPermissionsAll();
        for (Integer id : permissionsList) {
            userPermissionsService.updateNewUserPermissions(id);
        }
        //System.out.println(list);
        return Msg.success();
    }

    //找到当前全体管理员拥有的权限，将查找出来的实体的permissions元素，装换成string类型的数组，并向前台传送数据
    @RequestMapping("/admin/permission/toAdminPermissions.html")
    public String selectAdminPermissionsAll(Model model) {
        List<AdminPermissions> list = adminPermissionsService.selectAdminPermissionsAll();
        List<String> permissionsList = list.stream().map(AdminPermissions::getPermission).collect(Collectors.toList());
        // PageInfo<Permissions> pageInfo=new PageInfo<Permissions>(list);
        model.addAttribute("permissionsList", permissionsList);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "permissionActive");
        model.addAttribute("activeUrl2", "adminPermissionsActive");
        //model.addAttribute("username","username");
        return "admin/permission/adminpermissions";
    }

    //更新权限功能，将前台传回来的string类型的数据，通过split方法分割成string类型数组
    //通过permissionsService中的方法得到所有回传回来的权限元组
    //获取其id通过增强for循环对数据库中管理员的权限进行修改
    @RequestMapping("/admin/updateAdminPermissions")
    @ResponseBody
    public Msg AdminPermissions(@RequestParam("adminPermissions") String userPermission) {
        //String[] strings =userPermission.split(";");
        //得到允许的所有项目
        System.out.println("+++" + userPermission + "+++");
        //下面两个权限不能没有，所以返回不管有没有它都出于保险加上
        userPermission = userPermission.concat("admin:permission;admin:adminPermissions;");
        System.out.println(userPermission);
        String[] strings = userPermission.split(";");
        List<Permissions> list = permissionsService.selectPermissionsAll(strings);
        List<Integer> permissionsList = list.stream().map(Permissions::getId).collect(Collectors.toList());
        //状态设为0
        //循环updata状态为1
        System.out.println(permissionsList);
        adminPermissionsService.updateAdminPermissionsAll();
        for (Integer id : permissionsList) {
            adminPermissionsService.updateNewAdminPermissions(id);
        }
        //System.out.println(list);
        return Msg.success();
    }
}
