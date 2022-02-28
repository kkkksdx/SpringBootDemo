package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.FundProduct;
import com.demo.pojo.TermFinancial;
import com.demo.pojo.UserFlowOfFunds;
import com.demo.pojo.UserFundProduct;
import com.demo.service.FundProductService;
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
//基金理财模块
public class FundProductController {
    @Autowired
    private FundProductService fundProductService;
    @Autowired
    //查找出所有的FundProduct元组
    private UserToolsService userToolsService;

    @RequestMapping("/admin/finance/toFundProduct.html")
    public String selectUserAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<FundProduct> list = fundProductService.selectFundProductAll();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        PageInfo<FundProduct> pageInfo = new PageInfo<FundProduct>(list);

        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "fundproductActive");
        //model.addAttribute("username","username");
        return "admin/finance/fundproduct";
    }

    //增加资金理财
    @RequestMapping("/admin/addFundProduct")
    @ResponseBody
    public Msg insertUser(FundProduct fundProduct) {
        int i = fundProductService.addFundProduct(fundProduct);
        //System.out.println(payMoney);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //回显
    @RequestMapping("/admin/getFundProductInfoById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id) {
        FundProduct fundProduct = fundProductService.selectFundProductById(id);
        //System.out.println(changeMoney);
        return Msg.success().add("fundProduct", fundProduct);
    }

    //更新资金理财信息
    @RequestMapping("/admin/updateFundProduct/{id}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("id") Integer id, FundProduct fundProduct) {
        fundProduct.setId(id);
        int i = fundProductService.UpdateFundProduct(fundProduct);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //删除资金理财元组
    @RequestMapping("/admin/deleteFundProductById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id, FundProduct fundProduct) {
        int i = fundProductService.deleteFundProduct(fundProduct);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //用户模块基金理财
    @RequestMapping("/user/finance/toFundProduct.html")
    public String selectFundAll(Model model) {
        List<FundProduct> list = fundProductService.selectFundProductAll();
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserALL());
        model.addAttribute("fundProductList", list);
        model.addAttribute("activeUrl", "indexActive");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "fundProductActive");
        //model.addAttribute("username","username");
        return "user/finance/fundproduct";
    }

    //点击投资后，会向user_fund_product表中添加一条数据，同时会向flow_of_fund表中添加一条数据
    @RequestMapping("/user/buyFundProduct")
    @ResponseBody
    public Msg buyFundProduct(UserFundProduct userFundProduct,
                              @RequestParam("userId") Integer userId,
                              @RequestParam("fundProductId") Integer fundProductId) {
        userFundProduct.setUserId(userId);
        userFundProduct.setFundId(fundProductId);
        FundProduct fundProduct = fundProductService.selectFundProductById(fundProductId);
        userFundProduct.setMonthlyGrowth(fundProduct.getMonthlygrowth());

        userFundProduct.setProfit(fundProduct.getMonthlygrowth().multiply(fundProduct.getLeastmoney()));

        UserFlowOfFunds userFlowOfFunds = new UserFlowOfFunds();
        userFlowOfFunds.setSource(fundProduct.getFunddesc());
        userFlowOfFunds.setUserId(userId);
        userFlowOfFunds.setFlowmoney(fundProduct.getLeastmoney());
        userFlowOfFunds.setFunddesc("无");
        userToolsService.insertUserFlowOfFunds(userFlowOfFunds);

        int i = fundProductService.buyFundProduct(userFundProduct);
        if (i == 1)
            return Msg.success();
        else
            return Msg.fail();
    }
}
