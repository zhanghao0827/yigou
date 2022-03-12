package com.yigou.admin.mapper;

import com.yigou.common.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginLogMapper {

    int addLoginLog(LoginLog loginLog);

    List<LoginLog> getLoginLogs(String username);

}
