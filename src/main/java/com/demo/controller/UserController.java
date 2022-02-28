package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//后台用户信息模块
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userlist")
    public String selectUserAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectUserALL();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        PageInfo<User> pageInfo = new PageInfo<User>(list);

        model.addAttribute("userPageInfo", pageInfo);
        model.addAttribute("list", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "userInfoActive");
        model.addAttribute("username", "username");
        return "admin/userinfo/userinfo";
    }

    //增加操作
    @RequestMapping("/user/addUser")
    @ResponseBody
    public Msg insertUser(User user) {
        int i = userService.addUser(user);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //回显操作
    @RequestMapping("/user/getUserById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id) {
        User user = userService.selectUserById(id);
        System.out.println(user);
        return Msg.success().add("user", user);
    }

    //更新操作
    @RequestMapping("/user/updateUserProfile/{id}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("id") Integer id, User user) {
        user.setId(id);
        //System.out.println(user);
        User user1 = userService.selectUserById(id);
        user.setStatus(user1.getStatus());
        user.setPaypwd(user1.getPaypwd());
        user.setIdcard(user1.getIdcard());
        int i = userService.updateUser(user);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //删除操作
    @RequestMapping("/user/deleteUserById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id, User user) {
        user.setId(id);
        int i = userService.deleteUser(user);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
