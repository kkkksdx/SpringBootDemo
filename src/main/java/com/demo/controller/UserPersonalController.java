package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.*;
import com.demo.service.CardService;
import com.demo.service.UserPersonalService;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
//用户个人中心模块
public class UserPersonalController {
    @Autowired
    private UserPersonalService userPersonalService;
    @Autowired
    private UserService userService;

    //我的理财模块
    @RequestMapping("/user/personal/toMyFinance.html")
    public String myfinancial(Model model, HttpServletRequest httpServletRequest) {
        //System.out.println((Integer) httpServletRequest.getSession().getAttribute("id"));
        List<UserChangeMoney> list1 = userPersonalService.selectUserChangeMoney((Integer) httpServletRequest.getSession().getAttribute("id"));
        model.addAttribute("userChangeMoneyList", list1);
        //System.out.println(list1);

        List<UserPayMoney> list2 = userPersonalService.selectUserPayMoney((Integer) httpServletRequest.getSession().getAttribute("id"));
        model.addAttribute("userPayMoneyList", list2);

        List<UserTermFinacial> list3 = userPersonalService.selectUserTermFinacial((Integer) httpServletRequest.getSession().getAttribute("id"));
        model.addAttribute("userTermFinancialList", list3);

        List<UserFundProduct> list4 = userPersonalService.selectUserFundProduct((Integer) httpServletRequest.getSession().getAttribute("id"));
        model.addAttribute("userFundProductList", list4);
        model.addAttribute("myFinanceActiveUrl", "changeMoneyActive");
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "myFinanceActive");
        return "user/personal/myfinance";
    }

    //撤销零钱
    @RequestMapping("/user/revokeUserChangeMoney")
    @ResponseBody
    public Msg revokeUserChangeMoney(Integer userChangeMoneyId, HttpServletRequest httpServletRequest) {
        //System.out.println(userChangeMoneyId);
        int i = userPersonalService.updateUserChangeMoney(userChangeMoneyId);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }

    //撤销工资
    @RequestMapping("/user/revokeUserPayMoney")
    @ResponseBody
    public Msg revokeUserPayMoney(Integer userPayMoneyId) {
        int i = userPersonalService.updateUserPayMoney(userPayMoneyId);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }

    //撤销期限
    @RequestMapping("/user/revokeUserTermFinancial")
    @ResponseBody
    public Msg revokeUserTermFinancial(Integer userTermFinancialId) {
        int i = userPersonalService.updateUserTermFinacial(userTermFinancialId);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }

    //撤销基金
    @RequestMapping("/user/revokeUserFundProduct")
    @ResponseBody
    public Msg revokeUserFundProduct(Integer userFundProductId) {
        int i = userPersonalService.updateUserFundProduct(userFundProductId);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }

    //我的借贷模块
    @RequestMapping("/user/personal/toMyLoan.html")
    public String personalMyLoan(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 Model model, HttpServletRequest httpServletRequest) {

        PageHelper.startPage(pageNum, pageSize);
        List<UserLoan> list = userPersonalService.selectUserLoan((Integer) httpServletRequest.getSession().getAttribute("id"));
        PageInfo<UserLoan> pageInfo = new PageInfo<UserLoan>(list);
        model.addAttribute("myLoansPageInfo", pageInfo);
        model.addAttribute("loansList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "myLoanActive");
        return "user/personal/myloan";
    }

    //借贷还款
    @RequestMapping("/user/repayment/{id}")
    @ResponseBody
    public Msg rePayMent(@PathVariable("id") Integer id) {
        int i = userPersonalService.updateUserLoanStatus(id);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }

    //银行卡管理
    @RequestMapping("/user/personal/toBankCard.html")
    public String personalbankcard(HttpServletRequest httpServletRequest, Model model) {
        List<BankCard> list = userPersonalService.selectUserBankCard((Integer) httpServletRequest.getSession().getAttribute("id"));
        model.addAttribute("bankCardList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "bankCardActive");
        return "user/personal/bankcard";
    }

    //增加银行卡
    @RequestMapping("/user/addBankCard")
    @ResponseBody
    public Msg insertUser(BankCard bankCard, HttpServletRequest httpServletRequest) {
        bankCard.setUserId((Integer) httpServletRequest.getSession().getAttribute("id"));
        int i = userPersonalService.addBankCard(bankCard);
        // System.out.println(bankCard);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //账户安全
    @RequestMapping("/user/personal/toSecurity.html")
    public String personalSecurity(Model model) {
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "securityActive");
        return "user/personal/security";
    }

    //更新支付密码
    @RequestMapping("/user/updatePwd")
    @ResponseBody
    public Msg updatePwd(String oldpwd, String newpwd, Integer id) {
        User user = userPersonalService.chackUserPassword(id, oldpwd);
        if (user == null) {
            return Msg.fail();
        } else {
            int i = userPersonalService.changeUserPassword(id, newpwd);
            if (i == 1) {
                return Msg.success();
            } else {
                return Msg.fail();
            }
        }
    }

    //我的消息
    @RequestMapping("/user/personal/toMyInfo.html")
    public String personalMyInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 Model model, HttpServletRequest request) {

        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> list = userPersonalService.selectUserInfoAll((Integer) request.getSession().getAttribute("id"));
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        model.addAttribute("infoPageInfo", pageInfo);
        model.addAttribute("infoList", list);
        return "user/personal/myinfo";
    }

    //我的消息已读操作
    @RequestMapping("/user/updateInfo/{infoId}")
    @ResponseBody
    public Msg updateUserInfo(@PathVariable("infoId") Integer id, UserInfo userInfo) {
        userInfo.setId(id);
        int i = userPersonalService.updateUserInfo(userInfo);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //我的消息删除操作
    @RequestMapping("/user/deleteInfo/{infoId}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("infoId") Integer id, UserInfo userInfo) {
        userInfo.setId(id);
        int i = userPersonalService.deleteUserInfo(userInfo);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //个人信息
    @RequestMapping("/user/personal/toProfile.html")
    public String myProfile(Model model, HttpServletRequest request) {
        User user = new User();
        user = userService.selectUserById((Integer) request.getSession().getAttribute("id"));
        model.addAttribute("user", user);
        return "user/personal/profile";
    }

    //修改个人信息
    @RequestMapping("/user/updateUserProfilee/{userId}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("userId") Integer id, User user) {
        user.setId(id);
        User user1 = userService.selectUserById(id);
        user.setStatus(user1.getStatus());
        user.setPassword(user1.getPassword());
        //user.setIdcard(user1.getIdcard());
        int i = userService.updateUser(user);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
