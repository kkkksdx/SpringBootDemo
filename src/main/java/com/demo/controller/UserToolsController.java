package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.UserFlowOfFunds;
import com.demo.service.UserToolsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//用户金融工具模块
public class UserToolsController {
    @Autowired
    private UserToolsService userToolsService;

    //资金记录模块
    @RequestMapping("/user/tools/toRecord.html")
    public String personalSecurity(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                   HttpServletRequest httpServletRequest, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserFlowOfFunds> list = userToolsService.selectUserFlowOfFundsAll((Integer) httpServletRequest.getSession().getAttribute("id"));
        PageInfo<UserFlowOfFunds> pageInfo = new PageInfo<UserFlowOfFunds>(list);
        model.addAttribute("flowOfFundsPageInfo", pageInfo);
        model.addAttribute("flowOfFundsList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "toolsActive");
        model.addAttribute("activeUrl2", "recordActive");

        return "user/tools/record";
    }

    //安全网贷模块
    @RequestMapping("/user/tools/toApplyLoan.html")
    public String userApplyLoan(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "toolsActive");
        model.addAttribute("activeUrl2", "applyLoanActive");

        return "user/tools/applyloan";
    }

    //申请网贷
    @RequestMapping("/user/applyLoan")
    @ResponseBody
    public Msg revokeUserTermFinancial(@RequestParam("amout") String amout, @RequestParam("term") String term,
                                       @RequestParam("rate") String rate, HttpServletRequest httpServletRequest) {
        int i = userToolsService.addUserFlowOfFunds((Integer) httpServletRequest.getSession().getAttribute("id"), amout, term, rate);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }
}
