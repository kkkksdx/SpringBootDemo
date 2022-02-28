package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.BankCard;
import com.demo.service.CardService;
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
//后台银行卡模块
public class CardController {
    @Autowired
    private CardService cardService;

    //查找出所有的银行卡向前台传值
    @RequestMapping("/cardlist")
    public String selectBankCardALL(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<BankCard> list = cardService.selectBankCardALL();
        PageInfo<BankCard> pageInfo = new PageInfo<BankCard>(list);

        model.addAttribute("bankcardPageInfo", pageInfo);
        model.addAttribute("bankcardList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "bankcardActive");
        return "admin/userinfo/bankcard";
    }

    //通过id值查找银行卡号，实现回显功能
    @RequestMapping("/user/getBankCardById/{id}")
    @ResponseBody
    public Msg getBankCardById(@PathVariable("id") Integer id) {
        BankCard bankCard = cardService.selectBankCardById(id);
        //System.out.println(bankCard);
        return Msg.success().add("bankcard", bankCard);
    }

    //更新银行卡
    @RequestMapping("/user/updateBankCard/{id}")
    @ResponseBody
    public Msg updateBankCard(@PathVariable("id") Integer id, BankCard bankCard) {
        bankCard.setId(id);
        int i = cardService.updateBankCard(bankCard);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //删除银行卡
    @RequestMapping("/user/deleteBankCard/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id) {
        int i = cardService.deleteBankCard(id);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
