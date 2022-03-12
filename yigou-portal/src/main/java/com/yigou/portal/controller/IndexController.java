package com.yigou.portal.controller;

import com.yigou.common.entity.Advert;
import com.yigou.common.entity.CateMenu;
import com.yigou.portal.service.AdvertService;
import com.yigou.portal.service.CateMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class IndexController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    AdvertService advertService;

    @Autowired
    CateMenuService cateMenuService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        getAdverts(model);
        getCateMenus(model);
        return "index";
    }

    public void getAdverts(Model model) {
        //轮播图广告
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(ArrayList.class));
        List<Advert> advertList1 = (ArrayList<Advert>) redisTemplate.opsForValue().get("advertList1");
        if (advertList1 == null) {
            //没有缓存查询数据库
            advertList1 = advertService.getAdvertByTypeId(1);
            redisTemplate.opsForValue().set("advertList1", advertList1, 1L, TimeUnit.MINUTES);
        }
        model.addAttribute("advertList1", advertList1);
        //生鲜广告
        List<Advert> advertList10 = (ArrayList<Advert>) redisTemplate.opsForValue().get("advertList10");
        if (advertList10 == null) {
            //没有缓存查询数据库
            advertList10 = advertService.getAdvertByTypeId(10);
            redisTemplate.opsForValue().set("advertList10", advertList10, 2L, TimeUnit.MINUTES);
        }
        model.addAttribute("advertList10", advertList10);
    }

    public void getCateMenus(Model model) {
        List<CateMenu> cateMenus = cateMenuService.getCateMenus();
        //所有1级分类
        List<CateMenu> cateMenuList1 = filterCateMenu("1", cateMenus);
        //所有2级分类
        List<CateMenu> cateMenuList2 = filterCateMenu("2", cateMenus, cateMenuList1);
        //所有3级分类
        List<CateMenu> cateMenuList3 = filterCateMenu("3", cateMenus, cateMenuList1, cateMenuList2);
        model.addAttribute("cateMenuList1", cateMenuList1);
        model.addAttribute("cateMenuList2", cateMenuList2);
        model.addAttribute("cateMenuList3", cateMenuList3);
    }

    public List<CateMenu> filterCateMenu(String type, List<CateMenu>... sources) {
        List<CateMenu> cateMenus = new ArrayList<>();
        List<CateMenu> allList = sources[0];
        if ("1".equals(type)) {
            for (CateMenu cateMenu : allList) {
                if ("0".equals(cateMenu.getParentId().toString())) {
                    cateMenus.add(cateMenu);
                    if (cateMenus.size() == 10) {
                        //由于页面大小原因，目前显示十个
                        break;
                    }
                }
            }
        }
        if ("2".equals(type)) {
            List<CateMenu> cateMenus1 = sources[1];
            for (CateMenu cateMenu : cateMenus1) {
                for (CateMenu menu : allList) {
                    if (menu.getParentId().toString().equals(cateMenu.getId().toString())) {
                        cateMenus.add(menu);
                    }
                }
            }
        }

        if ("3".equals(type)) {
            List<CateMenu> cateMenus2 = sources[2];
            for (CateMenu cateMenu : cateMenus2) {
                for (CateMenu menu : allList) {
                    if (menu.getParentId().toString().equals(cateMenu.getId().toString())) {
                        cateMenus.add(menu);
                    }
                }
            }
        }

        return cateMenus;
    }


}
