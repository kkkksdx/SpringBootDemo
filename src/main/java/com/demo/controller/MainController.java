package com.demo.controller;

import com.demo.common.Msg;
import com.demo.mapper.UserMapper;
import com.demo.pojo.Bank;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@Controller
//后台主页
public class MainController {
    @Autowired
    private UserService userService;

    //将所需的用户信息传输给前台
    @RequestMapping("/admin/index.html")
    public String selectUserAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectUserALL();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("userPageInfo", pageInfo);
        model.addAttribute("userList", list);
        model.addAttribute("activeUrl", "indexActive");
        return "admin/main";
    }

    //强制下线功能通过invalidate方法实现强制下线
    @RequestMapping("/user/updateUserStatus/{id}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("id") Integer id, User user, HttpServletRequest request) {
        user.setId(id);
        //request.getSession().invalidate();
        Enumeration<String> enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            request.getSession().removeAttribute(key);
        }
        int i = userService.updateUserStatus(user);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
