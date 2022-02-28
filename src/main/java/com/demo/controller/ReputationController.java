package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReputationController {
    @Autowired
    private UserService userService;

    //查询出数据库中所有的用户信息向前台传值
    @RequestMapping("/reputationlist")
    public String selectReputationAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                      Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectReputationAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("userPageInfo", pageInfo);
        model.addAttribute("userList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "reputationActive");
        return "admin/userinfo/reputation";
    }

    //回显操作
    @RequestMapping("/user/getUserById2/{id}")
    @ResponseBody
    public Msg selectReputationById(@PathVariable("id") Integer id) {
        User user = userService.selectReputationById(id);
        System.out.println(id);
        return Msg.success().add("user", user);
    }

    //更新操作
    @RequestMapping("/user/updateUserProfile2/{id}")
    @ResponseBody
    public Msg updateUserReputation(@PathVariable("id") Integer id, User user) {
        user.setId(id);
        int i = userService.updateReputation(user);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
