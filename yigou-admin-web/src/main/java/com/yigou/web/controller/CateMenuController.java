package com.yigou.web.controller;

import com.yigou.common.entity.CateMenu;
import com.yigou.common.util.PageUtils;
import com.yigou.common.util.Result;
import com.yigou.web.service.CateMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cate_menu")
public class CateMenuController {

    @Autowired
    CateMenuService cateMenuService;

    @GetMapping("/")
    public String list(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                       @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                       @RequestParam(defaultValue = "0", required = false) Integer parentId, Model model) {
        PageUtils<CateMenu> pageUtils = cateMenuService.list(pageIndex, pageSize, parentId);
        boolean flag = false;//是否三级类目
        //面包屑
        String str = "<li><a href='javascript:queryChild(0);'>顶级分类列表</a></li>";
        if (parentId != 0) {
            //表示子分类
            CateMenu cateMenu1 = cateMenuService.getCateMenuById(parentId);
            if (cateMenu1 != null) {
                String name1 = cateMenu1.getName();
                String str1 = "<li><a href='javascript:queryChild(" + cateMenu1.getId() + ");'>" + name1 + "</a></li>";
                Integer parentId1 = cateMenu1.getParentId();
                CateMenu cateMenu2 = cateMenuService.getCateMenuById(parentId1);
                if (cateMenu2 != null) {
                    flag = true;
                    String name2 = cateMenu2.getName();
                    str = str + "<li><a href='javascript:queryChild(" + cateMenu2.getId() + ");'>" + name2 + "</a></li>";
                }
                str = str + str1;
            }
        }
        model.addAttribute("flag", flag);
        model.addAttribute("breadCrumb", str);
        model.addAttribute("pageUtils", pageUtils);
        model.addAttribute("parentId", parentId);
        return "cate_menu";
    }

    @PostMapping("/")
    @ResponseBody
    public Result add(CateMenu cateMenu) {
        int i = cateMenuService.addCateMenu(cateMenu);
        if (i > 0) {
            return Result.success("成功！");
        }
        return Result.error("失败！");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CateMenu getById(@PathVariable Integer id) {
        return cateMenuService.getCateMenuById(id);
    }

    @PutMapping("/")
    @ResponseBody
    public Result update(CateMenu cateMenu) {
        int i = cateMenuService.updateCateMenu(cateMenu);
        if (i > 0) {
            return Result.success("成功！");
        }
        return Result.error("失败！");
    }


}
