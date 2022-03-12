package com.yigou.admin.service.impl;

import com.yigou.admin.mapper.AdminMapper;
import com.yigou.admin.service.AdminService;
import com.yigou.common.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin selectAdmin(Admin admin) {
        return adminMapper.selectAdmin(admin);
    }
}
