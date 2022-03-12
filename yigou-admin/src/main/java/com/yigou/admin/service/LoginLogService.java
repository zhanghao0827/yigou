package com.yigou.admin.service;

import com.yigou.common.entity.LoginLog;

import java.util.List;

public interface LoginLogService {

    int addLoginLog(LoginLog loginLog);

    List<LoginLog> getLoginLogs(String username);
}
