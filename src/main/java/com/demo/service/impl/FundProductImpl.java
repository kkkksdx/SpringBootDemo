package com.demo.service.impl;

import com.demo.mapper.FundProductMapper;
import com.demo.pojo.FundProduct;
import com.demo.pojo.UserFundProduct;
import com.demo.service.FundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundProductImpl implements FundProductService {
    @Autowired
    private FundProductMapper fundProductMapper;

    public FundProductImpl() {
        super();
    }

    @Override
    public List<FundProduct> selectFundProductAll() {
        return fundProductMapper.selectFundProductAll();
    }

    @Override
    public int addFundProduct(FundProduct fundProduct) {
        return fundProductMapper.addFundProduct(fundProduct);
    }

    @Override
    public FundProduct selectFundProductById(Integer id) {
        return fundProductMapper.selectFundProductById(id);
    }

    @Override
    public int UpdateFundProduct(FundProduct fundProduct) {
        return fundProductMapper.UpdateFundProduct(fundProduct);
    }

    @Override
    public int deleteFundProduct(FundProduct fundProduct) {
        return fundProductMapper.deleteFundProduct(fundProduct);
    }
    @Override
    public int buyFundProduct(UserFundProduct userFundProduct){
        return fundProductMapper.buyFundProduct(userFundProduct);
    }
}
