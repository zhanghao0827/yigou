package com.yigou.advert.service;

import com.yigou.common.entity.AdType;

import java.util.List;
import java.util.Map;

public interface AdTypeService {

    int getTotalCount(Map<String, Object> map);

    List<AdType> getAdTypeList(Map<String, Object> map);

    int addAdType(AdType adType);

    int updateAdType(AdType adType);

    int deleteAdTypeById(Integer id);

    AdType getAdTypeById(Integer id);

    List<AdType> getAdTypes();
}
