package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.PayMoney;
import com.demo.pojo.TermFinancial;
import com.demo.pojo.UserFlowOfFunds;
import com.demo.pojo.UserTermFinacial;
import com.demo.service.TermFinancialService;
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

import java.util.List;

@Controller
//后台期限理财模块
public class TermFinancialController {
    @Autowired
    private TermFinancialService termFinancialService;
    @Autowired
    private UserToolsService userToolsService;
    //查询出term_financial中的所有数据
    @RequestMapping("/admin/finance/toTermFinancial.html")
    public String selectUserAll(@RequestParam(value="pageNum",defaultValue = "1")Integer pageNum,
                                @RequestParam(value="pageSize",defaultValue ="5")Integer pageSize,
                                Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<TermFinancial> list =termFinancialService.selectTermFinancialAll();
        PageInfo<TermFinancial> pageInfo=new PageInfo<TermFinancial>(list);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","termfinancialActive");
        return "admin/finance/termfinancial";
    }
    //增加操作
    @RequestMapping("/admin/addTermFinancial")
    @ResponseBody
    public Msg insertUser(TermFinancial termFinancial){
        int i=termFinancialService.addTermFinancial(termFinancial);
        //System.out.println(payMoney);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    //回显操作
    @RequestMapping("/admin/getTermFinancialInfoById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id){
        TermFinancial termFinancial= termFinancialService.selectTermFinancialById(id);
        //System.out.println(changeMoney);
        return Msg.success().add("termFinancial",termFinancial);
    }
    //更新操作
    @RequestMapping("/admin/updateTermFinancial/{id}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("id") Integer id,TermFinancial termFinancial){
        termFinancial.setId(id);
        int i=termFinancialService.UpdateTermFinancial(termFinancial);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    //删除操作
    @RequestMapping("/admin/deleteTermFinancialById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id,TermFinancial termFinancial){
        int i=termFinancialService.deleteTermFinancial(termFinancial);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    //用户期限理财
    @RequestMapping("/user/finance/toTermFinancial.html")
    public String selectFundAll(Model model){
        List<TermFinancial> list=termFinancialService.selectTermFinancialAll();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        model.addAttribute("termFinancialList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","termFinancialActive");
        //model.addAttribute("username","username");
        return "user/finance/termfinancial";
    }
    //点击投资，通过连表查询和计算得到足够的信息后
    // 会向user_term_financial表中添加一条数据，同时会向flow_of_fund表中添加一条数据
    @RequestMapping("user/buyTermFinancial")
    @ResponseBody
    public  Msg buyTermFinancial(UserTermFinacial userTermFinacial,
                                 @RequestParam("userId") Integer userId,
                                 @RequestParam("termFinancialId") Integer termFinancialId){
        userTermFinacial.setUserId(userId);
        userTermFinacial.setTermId(termFinancialId);
        TermFinancial termFinancial=termFinancialService.selectTermFinancialById(termFinancialId);
        userTermFinacial.setAverYield(termFinancial.getAnnualincome());
        userTermFinacial.setProfit(termFinancial.getAnnualincome().multiply(termFinancial.getLeastmoney()));
        System.out.println(userTermFinacial);

        UserFlowOfFunds userFlowOfFunds=new UserFlowOfFunds();
        userFlowOfFunds.setSource(termFinancial.getName());
        userFlowOfFunds.setUserId(userId);
        userFlowOfFunds.setFlowmoney(termFinancial.getLeastmoney());
        userFlowOfFunds.setFunddesc("无");
        userToolsService.insertUserFlowOfFunds(userFlowOfFunds);
        int i=termFinancialService.buyTermFinancial(userTermFinacial);
        if(i==1)
            return Msg.success();
        else
            return Msg.fail();
    }
}
