package com.yigou.spec.service.impl;

import com.yigou.common.entity.SpecOpt;
import com.yigou.spec.mapper.SpecOptMapper;
import com.yigou.spec.service.SpecOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecOptServiceImpl implements SpecOptService {

    @Autowired
    SpecOptMapper specOptMapper;


    @Override
    public int addSpecOpt(SpecOpt specOpt) {
        return specOptMapper.addSpecOpt(specOpt);
    }

    @Override
    public List<SpecOpt> getSpecOptBySpecId(Integer specId) {
        return specOptMapper.getSpecOptBySpecId(specId);
    }
}
