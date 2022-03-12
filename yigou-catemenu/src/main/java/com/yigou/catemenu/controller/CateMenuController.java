package com.yigou.catemenu.controller;

import com.yigou.catemenu.service.CateMenuService;
import com.yigou.common.entity.CateMenu;
import com.yigou.common.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cate_menu")
public class CateMenuController {

    @Autowired
    CateMenuService cateMenuService;

    @GetMapping("/")
    public PageUtils<CateMenu> list(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                    @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                    @RequestParam(defaultValue = "0", required = false) Integer parentId) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageIndex", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("parentId", parentId);
        int totalCount = cateMenuService.getTotalCount(parentId);
        List<CateMenu> cateMenuList = cateMenuService.getCateMenuList(map);
        return new PageUtils<>(pageIndex, pageSize, totalCount, cateMenuList);
    }

    @GetMapping("/{id}")
    public CateMenu getCateMenuById(@PathVariable Integer id) {
        return cateMenuService.getCateMenuById(id);
    }

    @GetMapping("/all")
    public List<CateMenu> getCateMenus() {
        return cateMenuService.getCateMenus();
    }

    @PostMapping("/")
    public int addCateMenu(@RequestBody CateMenu cateMenu) {
        return cateMenuService.addCateMenu(cateMenu);
    }

    @PutMapping("/")
    public int updateCateMenu(@RequestBody CateMenu cateMenu) {
        return cateMenuService.updateCateMenu(cateMenu);
    }

}
