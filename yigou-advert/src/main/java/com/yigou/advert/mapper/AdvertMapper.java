package com.yigou.advert.mapper;

import com.yigou.common.entity.Advert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdvertMapper {

    int getTotalCount();

    List<Advert> getAdvertList(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    List<Advert> getAdvertByTypeId(Integer id);

    int updateAdvertStatus(Map<String,Object> map);

    int addAdvert(Advert advert);

    Advert getAdvertById(Integer id);

    int updateAdvert(Advert advert);

}
