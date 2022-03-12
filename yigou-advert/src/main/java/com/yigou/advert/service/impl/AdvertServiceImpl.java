package com.yigou.advert.service.impl;

import com.yigou.advert.mapper.AdvertMapper;
import com.yigou.advert.service.AdvertService;
import com.yigou.common.entity.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    AdvertMapper advertMapper;


    @Override
    public int getTotalCount() {
        return advertMapper.getTotalCount();
    }

    @Override
    public List<Advert> getAdvertList(Integer pageIndex, Integer pageSize) {
        return advertMapper.getAdvertList(pageIndex, pageSize);
    }

    @Override
    public List<Advert> getAdvertByTypeId(Integer id) {
        return advertMapper.getAdvertByTypeId(id);
    }

    @Override
    public int updateAdvertStatus(Map<String, Object> map) {
        return advertMapper.updateAdvertStatus(map);
    }

    @Override
    public int addAdvert(Advert advert) {
        return advertMapper.addAdvert(advert);
    }

    @Override
    public Advert getAdvertById(Integer id) {
        return advertMapper.getAdvertById(id);
    }

    @Override
    public int updateAdvert(Advert advert) {
        return advertMapper.updateAdvert(advert);
    }
}
