package com.demo.controller;

import com.demo.pojo.News;
import com.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//用户主界面
public class UserMainController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/user/index.html")
    public String userMain(Model model) {
        List<News> list = newsService.selectNewsAll();
        model.addAttribute("newsList", list);
        return "user/main";
    }
}
