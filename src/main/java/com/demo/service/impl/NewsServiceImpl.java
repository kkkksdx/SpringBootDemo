package com.demo.service.impl;

import com.demo.mapper.NewsMapper;
import com.demo.pojo.News;
import com.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> selectNewsAll() {
        return newsMapper.selectNewsAll();
    }
}
