package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Admin;
import com.demo.pojo.User;
import com.demo.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//注册模块
public class LoginController {

    @Autowired
    private LoginService loginService;

    //查询输入的username是否在数据库中
    @RequestMapping("/login/loginVerifyUsername/{username}")
    @ResponseBody
    public Msg login(@PathVariable("username") String username, HttpServletRequest request) {
        Admin admin = loginService.selectAdminByUserName(username);
        User user = loginService.selectUserByUserName(username);
        //先查询是否为管理员的用户名，若不是查询是否为用户的用户名，若还不是则返回msg.fail（）
        if (admin != null) {
            request.getSession().setAttribute("username", admin.getUsername());
            return Msg.success();
        } else if (user != null) {
            request.getSession().setAttribute("loginUser", user);
            request.getSession().setAttribute("id", user.getId());
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //登录，首先接受前端传回来的username和password，创建UsernamePasswordToken的参数token，通过realm函数进行授权认证
    @RequestMapping("/login/verifyLogin")
    @ResponseBody
    public Msg adminOrUserLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpServletRequest request) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin admin1 = loginService.adminLogin(admin);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = loginService.userLogin(user);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //如果用户名和密码输入有误，realm中的函数会抛出IncorrectCredentialsException类型的异常
        //catch到此类型的异常则返回msg.fail（）
        if (admin1 != null) {
            try {
                subject.login(token);
            } catch (IncorrectCredentialsException e) {
                return Msg.fail();
            }
            return Msg.success().add("url", "/admin/index.html");
        } else if (user1 != null) {
            try {
                subject.login(token);
            } catch (IncorrectCredentialsException e) {
                return Msg.fail();
            }
            return Msg.success().add("url", "/user/index.html");
        } else {
            return Msg.fail();
        }
    }

    //用户注册模块
    @RequestMapping("/toregister.html")
    public String register() {
        return "register";
    }

    //注册成功向user表中添加新的元组
    @RequestMapping("/login/register")
    @ResponseBody
    public Msg userRegister(Admin admin) {
        System.out.println(admin);
        int i = loginService.userRegister(admin);
        if (i == 1)
            return Msg.success().add("url", "/");//有bug会生产多项同名用户而导致检测失误
        else
            return Msg.fail();
    }
}
