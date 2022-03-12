package com.yigou.brand.service;

import com.yigou.common.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getBrands();

    int addBrand(Brand brand);

    int updateBrand(Brand brand);

    Brand getBrandById(Integer id);

    int deleteBrandById(Integer id);

    int deleteBatch(Integer[] ids);

    int getTotalCount();

    List<Brand> getBrandListByPage(int pageIndex, int pageSize);

}
