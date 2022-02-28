package com.demo.controller;

import com.demo.pojo.Admin;
import com.demo.pojo.User;
import com.demo.service.AdminService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
//@RequestMapping("/user")
//登录模块，用户和管理员退出模块
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    //收到请求“/”后返回login界面
    @RequestMapping("/")
    public String test() {
        return "login";
    }

    //用户退出，修改status值，并清空session
    @RequestMapping("/outuser")
    public String outtest(HttpServletRequest request, User user) {
        user.setId((Integer) request.getSession().getAttribute("id"));
        userService.updateUserStatus(user);
        //httpServletRequest.getSession().invalidate();
        Enumeration<String> enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            request.getSession().removeAttribute(key);
        }
        return "login";
    }

    //管理员退出，修改status值，并清空session
    @RequestMapping("/outadmin")
    public String outadmintest(HttpServletRequest request) {
        Admin admin = adminService.selectUserByUserName("admin");
        admin.setStatus(0);
        adminService.updateAdmin(admin);
        //httpServletRequest.getSession().invalidate();
        Enumeration<String> enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            request.getSession().removeAttribute(key);
        }
        return "login";
    }
}
