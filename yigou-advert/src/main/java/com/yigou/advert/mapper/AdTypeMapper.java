package com.yigou.advert.mapper;

import com.yigou.common.entity.AdType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdTypeMapper {

    int getTotalCount(Map<String, Object> map);

    List<AdType> getAdTypeList(Map<String, Object> map);

    int addAdType(AdType adType);

    int updateAdType(AdType adType);

    int deleteAdTypeById(Integer id);

    AdType getAdTypeById(Integer id);

    List<AdType> getAdTypes();
}
