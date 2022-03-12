package com.yigou.catemenu.service.impl;

import com.yigou.catemenu.mapper.CateMenuMapper;
import com.yigou.catemenu.service.CateMenuService;
import com.yigou.common.entity.CateMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CateMenuServiceImpl implements CateMenuService {

    @Autowired
    CateMenuMapper cateMenuMapper;

    @Override
    public int getTotalCount(Integer parentId) {
        return cateMenuMapper.getTotalCount(parentId);
    }

    @Override
    public List<CateMenu> getCateMenuList(Map<String, Object> map) {
        return cateMenuMapper.getCateMenuList(map);
    }

    @Override
    public CateMenu getCateMenuById(Integer id) {
        return cateMenuMapper.getCateMenuById(id);
    }

    @Override
    public List<CateMenu> getCateMenus() {
        return cateMenuMapper.getCateMenus();
    }

    @Override
    public int addCateMenu(CateMenu cateMenu) {
        return cateMenuMapper.addCateMenu(cateMenu);
    }

    @Override
    public int updateCateMenu(CateMenu cateMenu) {
        return cateMenuMapper.updateCateMenu(cateMenu);
    }
}
