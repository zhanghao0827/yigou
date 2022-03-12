package com.yigou.statical;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yigou.common.bean.AttrBean;
import com.yigou.common.bean.OrderUrlBean;
import com.yigou.common.bean.SkuBean;
import com.yigou.common.entity.Brand;
import com.yigou.common.entity.Goods;
import com.yigou.common.entity.GoodsDetail;
import com.yigou.common.entity.Item;
import com.yigou.common.util.JsonUtils;
import com.yigou.statical.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class StaticTest1 {

    @Test
    public void test() throws IOException {
        //创建模板加载器
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        //模板路径
        templateResolver.setPrefix("templates/");
        //模板后缀
        templateResolver.setSuffix(".html");
        //创建模板引擎
        TemplateEngine templateEngine = new TemplateEngine();
        //加载器加入模板引擎
        templateEngine.setTemplateResolver(templateResolver);
        //静态页面生成的文件地址
        FileWriter fileWriter = new FileWriter("F:\\Desktop\\templates\\test.html");
        //创建Context对象
        Context context = new Context();
        //放入测试数据
        context.setVariable("msg", "满城尽带黄金甲");
        //生成页面
        templateEngine.process("demo", context, fileWriter);
    }

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsDetailService goodsDetailService;

    @Autowired
    BrandService brandService;

    @Autowired
    CateMenuService cateMenuService;

    @Autowired
    ItemService itemService;

    @Test
    public void test2() throws IOException {
        Goods goods = goodsService.getById(1);
        GoodsDetail goodsDetail = goodsDetailService.getById(goods.getId());
        String goodsImg = goodsDetail.getGoodsImg();

        //品牌
        Integer brandId = goods.getBrandId();
        Brand brand = brandService.getBrandById(brandId);

        //类目
        String cateMenuName1 = cateMenuService.getCateMenuById(goods.getCateMenu1Id()).getName();
        String cateMenuName2 = cateMenuService.getCateMenuById(goods.getCateMenu2Id()).getName();
        String cateMenuName3 = cateMenuService.getCateMenuById(goods.getCateMenu3Id()).getName();
        String cateMenuName = cateMenuName1 + " > " + cateMenuName2 + " > " + cateMenuName3;

        //规格
        String goodsAttr = goodsDetail.getGoodsAttr();
        List<AttrBean> attrList = JsonUtils.parseJson2ListByAttr(goodsAttr);

        //sku
        List<Item> itemList = itemService.getItemsByGoodsId(goods.getId());
        List<SkuBean> skuList = new ArrayList<>();
        for (Item item : itemList) {
            Integer itemId = item.getId();
            String itemTitle = item.getTitle();
            Double itemPrice = item.getPrice();
            String itemSpec = item.getSpec();
            Map<String, Object> map = JsonUtils.parseJson2Map(itemSpec);
            SkuBean skuBean = new SkuBean(itemId, itemTitle, itemPrice, map);
            skuList.add(skuBean);
        }
        //skuList转json
        String skuJson = new ObjectMapper().writeValueAsString(skuList);

        System.out.println(skuJson);

        List<OrderUrlBean> goodsImgList = JsonUtils.parseJson2ListByOrderUrl(goodsImg);
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        FileWriter fileWriter = new FileWriter("F:\\Desktop\\templates\\goods_detail_" + goods.getId() + ".html");
        Context context = new Context();

        context.setVariable("goods", goods);
        context.setVariable("goodsDetail", goodsDetail);
        context.setVariable("goodsImgList", goodsImgList);
        context.setVariable("brand", brand);
        context.setVariable("cateMenuName", cateMenuName);
        context.setVariable("attrList", attrList);
        context.setVariable("skuJson", skuJson);

        templateEngine.process("goods_detail", context, fileWriter);
    }

    @Test
    public void test3() {
        GoodsDetail goodsDetail = goodsDetailService.getById(1);
        String goodsImg = goodsDetail.getGoodsImg();
        List<OrderUrlBean> orderUrlBeans = JsonUtils.parseJson2ListByOrderUrl(goodsImg);
        System.out.println("orderUrlBeans = " + orderUrlBeans);
    }
}
