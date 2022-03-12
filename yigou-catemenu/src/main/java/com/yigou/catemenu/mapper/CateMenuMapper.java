package com.yigou.catemenu.mapper;

import com.yigou.common.entity.CateMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CateMenuMapper {

    int getTotalCount(Integer parentId);

    List<CateMenu> getCateMenuList(Map<String, Object> map);

    CateMenu getCateMenuById(Integer id);

    List<CateMenu> getCateMenus();

    int addCateMenu(CateMenu cateMenu);

    int updateCateMenu(CateMenu cateMenu);

}
