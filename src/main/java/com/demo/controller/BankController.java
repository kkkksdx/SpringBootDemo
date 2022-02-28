package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.Bank;
import com.demo.pojo.ChangeMoney;
import com.demo.service.BankService;
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
//精选银行模块
public class BankController {
    @Autowired
    private BankService bankService;

    //查询出所有的银行向前台传值
    @RequestMapping("/admin/finance/toBank.html")
    public String selectUserAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bank> list = bankService.selectBankAll();
        PageInfo<Bank> pageInfo = new PageInfo<Bank>(list);

        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "bankctive");
        return "admin/finance/bank";
    }

    //增加银行
    @RequestMapping("/admin/addBank")
    @ResponseBody
    public Msg insertUser(Bank bank) {
        int i = bankService.addBank(bank);
        //System.out.println(changeMoney);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //回显，通过id找到银行
    @RequestMapping("/admin/getBankInfoById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id) {
        Bank bank = bankService.selectBankById(id);
        //System.out.println(changeMoney);
        return Msg.success().add("bank", bank);
    }

    //修改银行信息，接收前台传过来的id值，通过此id值实现对制定银行的更新
    @RequestMapping("/admin/updateBank/{id}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("id") Integer id, Bank bank) {
        bank.setId(id);
        int i = bankService.UpdateBank(bank);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //删除银行
    @RequestMapping("/admin/deleteBankById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id, Bank bank) {
        bank.setId(id);
        int i = bankService.deleteBank(bank);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //用户银行推荐
    @RequestMapping("/user/finance/toBank.html")
    public String selectFundAll(Model model) {
        List<Bank> list = bankService.selectBankAll();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        model.addAttribute("bankList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "bankActive");
        //model.addAttribute("username","username");
        return "user/finance/bank";
    }
}
