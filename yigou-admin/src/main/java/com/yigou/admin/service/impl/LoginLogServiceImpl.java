package com.yigou.admin.service.impl;

import com.yigou.admin.mapper.LoginLogMapper;
import com.yigou.admin.service.LoginLogService;
import com.yigou.common.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public int addLoginLog(LoginLog loginLog) {
        return loginLogMapper.addLoginLog(loginLog);
    }

    @Override
    public List<LoginLog> getLoginLogs(String username) {
        return loginLogMapper.getLoginLogs(username);
    }
}
