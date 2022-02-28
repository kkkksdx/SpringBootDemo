package com.demo.service;

import com.demo.pojo.FundProduct;
import com.demo.pojo.UserFundProduct;

import java.util.List;

public interface FundProductService {
    public List<FundProduct> selectFundProductAll();
    public int addFundProduct(FundProduct fundProduct);
    public FundProduct selectFundProductById(Integer id);
    public int UpdateFundProduct(FundProduct fundProduct);
    public  int deleteFundProduct(FundProduct fundProduct);
    public int buyFundProduct(UserFundProduct userFundProduct);
}
