package com.yigou.catemenu.service;

import com.yigou.common.entity.CateMenu;

import java.util.List;
import java.util.Map;

public interface CateMenuService {

    int getTotalCount(Integer parentId);

    List<CateMenu> getCateMenuList(Map<String, Object> map);

    CateMenu getCateMenuById(Integer id);

    List<CateMenu> getCateMenus();

    int addCateMenu(CateMenu cateMenu);

    int updateCateMenu(CateMenu cateMenu);
}
