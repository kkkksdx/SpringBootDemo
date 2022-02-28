package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.Loan;
import com.demo.service.LoanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
//后台网贷管理模块
public class LoanController {
    @Autowired
    private LoanService loanService;

    //查询出所有的网贷记录
    @RequestMapping("/admin/loan/toLoanexam.html")
    public String selectLoanAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<Loan> list = loanService.selectLoanAll();
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(list);
        model.addAttribute("loanPageInfo", pageInfo);
        model.addAttribute("loanList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "loanActive");
        model.addAttribute("activeUrl2", "loanexamActive");
        return "admin/loan/loanexam";
    }

    //查询出所有的审核通过的网贷记录
    @RequestMapping("/admin/loan/toLoaninfo.html")
    public String selectLoaninfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 Model model) {
        //PageHelper.startPage(pageNum, pageSize);
        //传值之前先对是否逾期进行更新
        List<Loan> list1 = loanService.selectLoaninfo();
        //查询出所有元组的id值通过增强for循环分别对元组进行更新操作
        List<Integer> idList = list1.stream().map(Loan::getId).collect(Collectors.toList());
        for (Integer id : idList) {
            Loan loan = loanService.selectNotice(id);
            Date date = new Date(System.currentTimeMillis());
            int days = (int) ((date.getTime() - loan.getLoanTime().getTime()) / (1000 * 3600 * 24));
            if (days > loan.getTerm() && loan.getLoanstatus() != 2)
                loanService.checkLoan(id);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Loan> list = loanService.selectLoaninfo();
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(list);
        model.addAttribute("loanPageInfo", pageInfo);
        model.addAttribute("loanList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "loanActive");
        model.addAttribute("activeUrl2", "loaninfoActive");
        return "admin/loan/loaninfo";
    }

    //网贷审核通过，修改网贷审核状态值并向用户发送消息（向info表中添加元组）
    @RequestMapping("/loan/passApplyStatus/{id}")
    @ResponseBody
    public Msg checkPass(@PathVariable("id") Integer id) {
        Loan loan = loanService.selectNotice(id);
        loan.setPhone("用户" + loan.getUsername() + "的" + loan.getAmount() + "元网贷申请审核通过！审核人为：admin");
        loan.setIdcard("网贷审核通过");
        System.out.println(loan);
        int i = loanService.checkPass(id);
        loanService.sendNotice(loan);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }

    //网贷审核未通过，向用户发送消息（向info表中添加元组）
    @RequestMapping("/loan/notPassApplyStatus/{id}")
    @ResponseBody
    public Msg checkNoPass(@PathVariable("id") Integer id) {
        Loan loan = loanService.selectNotice(id);
        loan.setPhone("用户" + loan.getUsername() + "的" + loan.getAmount() + "元网贷申请审核未通过！审核人为：admin");
        loan.setIdcard("网贷审核未通过");
        System.out.println(loan);
        int i = loanService.checkNoPass(id);
        loanService.sendNotice(loan);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }

    //还款提醒，向用户info表中添加新的元组
    @RequestMapping("/loan/remindPay/{id}")
    @ResponseBody
    public Msg sendNotice(@PathVariable("id") Integer id) {
        Loan loan = loanService.selectNotice(id);
        loan.setPhone("用户" + loan.getUsername() + "申请的" + loan.getAmount() + "元网贷该还款了！该提醒发送人为：admin");
        loan.setIdcard("还款通知");
//        Date date=new Date(System.currentTimeMillis());
//        int days = (int) ((date.getTime() - loan.getLoanTime().getTime()) / (1000*3600*24));
//        if(days>loan.getTerm()&&loan.getLoanstatus()!=2)
//            loanService.checkLoan(id);
//        System.out.println(loan.getLoanstatus());
        int i = loanService.sendNotice(loan);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }
}
