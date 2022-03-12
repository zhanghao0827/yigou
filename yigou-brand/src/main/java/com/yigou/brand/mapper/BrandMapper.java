package com.yigou.brand.mapper;

import com.yigou.common.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {

    List<Brand> getBrands();

    int addBrand(Brand brand);

    int updateBrand(Brand brand);

    Brand getBrandById(Integer id);

    int deleteBrandById(Integer id);

    int deleteBatch(@Param("ids") Integer[] ids);

    int getTotalCount();

    List<Brand> getBrandListByPage(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

}
