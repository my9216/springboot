package com.service.impl;

import com.mapper.YueTest1Mapper;
import com.model.BaseYueTest;
import com.service.IYueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class YueServiceImpl implements IYueService {
    @Resource
    YueTest1Mapper yueTest;
    @Override
    public BaseYueTest getBaseYueInfo(int i) {
        return yueTest.getBaseYueInfo(i);
    }
}
