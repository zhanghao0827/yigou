package com.yigou.advert.service.impl;

import com.yigou.advert.mapper.AdTypeMapper;
import com.yigou.advert.service.AdTypeService;
import com.yigou.common.entity.AdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdTypeServiceImpl implements AdTypeService {

    @Autowired
    AdTypeMapper adTypeMapper;

    @Override
    public int getTotalCount(Map<String, Object> map) {
        return adTypeMapper.getTotalCount(map);
    }

    @Override
    public List<AdType> getAdTypeList(Map<String, Object> map) {
        return adTypeMapper.getAdTypeList(map);
    }

    @Override
    public int addAdType(AdType adType) {
        return adTypeMapper.addAdType(adType);
    }

    @Override
    public int updateAdType(AdType adType) {
        return adTypeMapper.updateAdType(adType);
    }

    @Override
    public int deleteAdTypeById(Integer id) {
        return adTypeMapper.deleteAdTypeById(id);
    }

    @Override
    public AdType getAdTypeById(Integer id) {
        return adTypeMapper.getAdTypeById(id);
    }

    @Override
    public List<AdType> getAdTypes() {
        return adTypeMapper.getAdTypes();
    }
}
