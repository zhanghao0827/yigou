package com.yigou.user.mapper;

import com.yigou.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int addUser(User user);
}
