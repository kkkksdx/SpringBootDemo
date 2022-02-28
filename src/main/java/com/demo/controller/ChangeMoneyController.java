package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.ChangeMoney;
import com.demo.pojo.UserChangeMoney;
import com.demo.pojo.UserFlowOfFunds;
import com.demo.service.ChangeMoneyService;
import com.demo.service.UserPersonalService;
import com.demo.service.UserToolsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
//零钱理财模块
public class ChangeMoneyController {
    @Autowired
    private ChangeMoneyService changeMoneyService;
    @Autowired
    private UserToolsService userToolsService;

    //查询出changemoney表中的所有元组向前台传值
    @RequestMapping("/admin/finance/toChangeMoney.html")
    public String selectUserAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChangeMoney> list = changeMoneyService.selectChangeMoneyAll();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        PageInfo<ChangeMoney> pageInfo = new PageInfo<ChangeMoney>(list);

        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "changemoneyActive");
        //model.addAttribute("username","username");
        return "admin/finance/changemoney";
    }

    //增加操作
    @RequestMapping("/admin/addChangeMoney")
    @ResponseBody
    public Msg insertUser(ChangeMoney changeMoney) {
        int i = changeMoneyService.addChangeMoney(changeMoney);
        System.out.println(changeMoney);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //回显操作
    @RequestMapping("/admin/getChangeMoneyInfoById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id) {
        ChangeMoney changeMoney = changeMoneyService.selectChangeMoneyById(id);
        //System.out.println(changeMoney);
        return Msg.success().add("changeMoney", changeMoney);
    }

    //更新操作
    @RequestMapping("/admin/updateChangeMoney/{id}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("id") Integer id, ChangeMoney changeMoney) {
        changeMoney.setId(id);
        int i = changeMoneyService.UpdateChangeMoney(changeMoney);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //删除操作
    @RequestMapping("/admin/deleteChangeMoneyById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id, ChangeMoney changeMoney) {
        changeMoney.setId(id);
        int i = changeMoneyService.deleteChangeMoney(changeMoney);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //用户零钱理财
    @RequestMapping("/user/finance/toChangeMoney.html")
    public String selectChargeAll(Model model) {
        List<ChangeMoney> list = changeMoneyService.selectChangeMoneyAll();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        model.addAttribute("changeMoneyList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "changemoneyActive");
        //model.addAttribute("username","username");
        return "user/finance/changemoney";
    }

    //点击投资后，会向user_change_money表中添加一条数据，同时会向flow_of_fund表中添加一条数据
    @RequestMapping("/user/buyChangeMoney")
    @ResponseBody
    public Msg buyChangeMoney(UserChangeMoney userChangeMoney,
                              @RequestParam("userId") Integer userId,
                              @RequestParam("changeMoneyId") Integer changeMoneyId
    ) {
        userChangeMoney.setUserId(userId);
        userChangeMoney.setChangeId(changeMoneyId);
        ChangeMoney changeMoney = changeMoneyService.selectChangeMoneyById(changeMoneyId);
        userChangeMoney.setAverYield(changeMoney.getAnnualincome());
        userChangeMoney.setProfit(changeMoney.getAnnualincome().multiply(changeMoney.getInvesmoney()));
        System.out.println(userChangeMoney.getProfit());

        UserFlowOfFunds userFlowOfFunds = new UserFlowOfFunds();
        userFlowOfFunds.setSource(changeMoney.getName());
        userFlowOfFunds.setUserId(userId);
        userFlowOfFunds.setFlowmoney(changeMoney.getInvesmoney());
        userFlowOfFunds.setFunddesc("无");
        userToolsService.insertUserFlowOfFunds(userFlowOfFunds);

        int i = changeMoneyService.buyChangeMoney(userChangeMoney);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }
}
