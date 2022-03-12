package com.yigou.spec.mapper;

import com.yigou.common.entity.SpecOpt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecOptMapper {

    int addSpecOpt(SpecOpt specOpt);

    List<SpecOpt> getSpecOptBySpecId(Integer specId);

    int deleteSpecOptBySpecId(Integer specId);
}
