package com.yigou.brand.service.impl;

import com.yigou.brand.mapper.BrandMapper;
import com.yigou.brand.service.BrandService;
import com.yigou.common.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<Brand> getBrands() {
        return brandMapper.getBrands();
    }

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.addBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.getBrandById(id);
    }

    @Override
    public int deleteBrandById(Integer id) {
        return brandMapper.deleteBrandById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return brandMapper.deleteBatch(ids);
    }

    @Override
    public int getTotalCount() {
        return brandMapper.getTotalCount();
    }

    @Override
    public List<Brand> getBrandListByPage(int pageIndex, int pageSize) {
        return brandMapper.getBrandListByPage(pageIndex, pageSize);
    }
}
