package com.yigou.admin.mapper;

import com.yigou.common.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Admin selectAdmin(Admin admin);


}
