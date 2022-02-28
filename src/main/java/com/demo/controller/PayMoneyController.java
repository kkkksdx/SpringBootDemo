package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.ChangeMoney;
import com.demo.pojo.PayMoney;
import com.demo.pojo.UserFlowOfFunds;
import com.demo.pojo.UserPayMoney;
import com.demo.service.PayMoneyService;
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
//工资理财模块
public class PayMoneyController {
    @Autowired
    private PayMoneyService payMoneyService;
    @Autowired
    private UserToolsService userToolsService;

    //查询出所有pay_money表中数据，并向前台传值
    @RequestMapping("/admin/finance/toPayMoney.html")
    public String selectUserAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<PayMoney> list = payMoneyService.selectPayMoneyAll();
        PageInfo<PayMoney> pageInfo = new PageInfo<PayMoney>(list);
        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "paymoneyActive");
        return "admin/finance/paymoney";
    }

    //增加操作
    @RequestMapping("/admin/addPayMoney")
    @ResponseBody
    public Msg insertUser(PayMoney payMoney) {
        int i = payMoneyService.addPayMoney(payMoney);
        //System.out.println(payMoney);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //回显操作
    @RequestMapping("/admin/getPayMoneyInfoById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id) {
        PayMoney payMoney = payMoneyService.selectPayMoneyById(id);
        //System.out.println(changeMoney);
        return Msg.success().add("payMoney", payMoney);
    }

    //更新操作
    @RequestMapping("/admin/updatePayMoney/{id}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("id") Integer id, PayMoney payMoney) {
        payMoney.setId(id);
        int i = payMoneyService.UpdatePayMoney(payMoney);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //删除操作
    @RequestMapping("/admin/deletePayMoneyById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id) {
        int i = payMoneyService.DeletePayMoney(id);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //用户工资理财
    @RequestMapping("/user/finance/toPayMoney.html")
    public String selectFundAll(Model model) {
        List<PayMoney> list = payMoneyService.selectPayMoneyAll();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        model.addAttribute("payMoneyList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "payMoneyActive");
        //model.addAttribute("username","username");
        return "user/finance/paymoney";
    }

    //点击投资，通过连表查询和计算得到足够的信息后
    // 会向user_pay_money表中添加一条数据，同时会向flow_of_fund表中添加一条数据
    @RequestMapping("/user/buyPayMoney")
    @ResponseBody
    public Msg buyPayMoney(UserPayMoney userPayMoney,
                           @RequestParam("userId") Integer userId,
                           @RequestParam("payMoneyId") Integer payMoneyId) {
        userPayMoney.setUserId(userId);
        userPayMoney.setPayId(payMoneyId);
        PayMoney payMoney = payMoneyService.selectPayMoneyById(payMoneyId);
        BigDecimal e = new BigDecimal(0.03123000);
        userPayMoney.setAverYield(e);
        userPayMoney.setProfit(payMoney.getMonthmoney().multiply(e));

        UserFlowOfFunds userFlowOfFunds = new UserFlowOfFunds();
        userFlowOfFunds.setSource("工资理财");
        userFlowOfFunds.setUserId(userId);
        userFlowOfFunds.setFlowmoney(payMoney.getMonthmoney());
        String s;
        if (payMoney.getType() == 1)
            s = "国债";
        else
            s = "期货";
        userFlowOfFunds.setFunddesc(s);
        userToolsService.insertUserFlowOfFunds(userFlowOfFunds);

        int i = payMoneyService.buyPayMoney(userPayMoney);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }
}
