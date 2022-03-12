package com.yigou.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yigou.common.bean.JsonBean;
import com.yigou.common.bean.JsonText;
import com.yigou.common.entity.Brand;
import com.yigou.common.entity.Spec;
import com.yigou.common.entity.Template;
import com.yigou.common.util.JsonUtils;
import com.yigou.common.util.PageUtils;
import com.yigou.common.util.Result;
import com.yigou.web.service.BrandService;
import com.yigou.web.service.SpecService;
import com.yigou.web.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @Autowired
    BrandService brandService;

    @Autowired
    SpecService specService;

    @GetMapping("/")
    public String getTemplateList(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                  @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                  @RequestParam(defaultValue = "", required = false) String name, Model model) {
        PageUtils<Template> pageUtils = templateService.getTemplateList(pageIndex, pageSize, name);
        model.addAttribute("pageUtils", pageUtils);
        model.addAttribute("name", name);
        return "template";
    }

    @GetMapping("/bs")
    @ResponseBody
    public Map<String, Object> getBrandAndSpec() {
        List<Brand> brands = brandService.getBrands();
        List<Spec> specs = specService.getSpecs();
        Map<String, Object> map = new HashMap<>();
        map.put("brands", brands);
        map.put("specs", specs);
        return map;
    }

    @PostMapping("/")
    @ResponseBody
    public Result add(Template template, Integer[] brandId, Integer[] specId, String[] attribute) throws JsonProcessingException {
        List<JsonBean> jsonBeanList = new ArrayList<>();
        for (Integer bId : brandId) {
            JsonBean jsonBean = new JsonBean();
            String name = brandService.getBrandById(bId).getName();
            jsonBean.setId(bId);
            jsonBean.setText(name);
            jsonBeanList.add(jsonBean);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBrand = objectMapper.writeValueAsString(jsonBeanList);

        List<JsonBean> jsonBeans = new ArrayList<>();
        for (Integer sId : specId) {
            JsonBean jsonBean = new JsonBean();
            String name = specService.getSpecById(sId).getSpecName();
            jsonBean.setId(sId);
            jsonBean.setText(name);
            jsonBeans.add(jsonBean);
        }
        String jsonSpec = objectMapper.writeValueAsString(jsonBeans);

        List<JsonText> jsonTextList = new ArrayList<>();
        for (String attr : attribute) {
            JsonText jsonText = new JsonText();
            jsonText.setText(attr);
            jsonTextList.add(jsonText);
        }
        String jsonAttr = objectMapper.writeValueAsString(jsonTextList);

        template.setSpecId(jsonSpec);
        template.setBrandId(jsonBrand);
        template.setAttribute(jsonAttr);
        int i = templateService.addTemplate(template);
        if (i > 0) {
            return Result.success("成功！");
        }
        return Result.error("失败！");
    }

    @GetMapping("/upd/{id}")
    @ResponseBody
    public Map<String, Object> goUpdate(@PathVariable Integer id) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        Template template = templateService.getTemplateById(id);

        List<JsonBean> jsonBrands = JsonUtils.parseJson2List(template.getBrandId());
        List<Brand> brands = brandService.getBrands();
        for (Brand brand : brands) {
            for (JsonBean jsonBrand : jsonBrands) {
                if (brand.getId().equals(jsonBrand.getId())) {
                    //选中
                    brand.setChecked(true);
                }
            }
        }

        List<Spec> specs = specService.getSpecs();
        List<JsonBean> jsonSpecs = JsonUtils.parseJson2List(template.getSpecId());
        for (Spec spec : specs) {
            for (JsonBean jsonSpec : jsonSpecs) {
                if (spec.getId().equals(jsonSpec.getId())) {
                    spec.setChecked(true);
                }
            }
        }

        String attribute = template.getAttribute();
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonText> attributes = objectMapper.readValue(attribute, new TypeReference<ArrayList<JsonText>>() {
        });
        map.put("template", template);
        map.put("brands", brands);
        map.put("specs", specs);
        map.put("attributes", attributes);
        return map;
    }


    @PutMapping("/")
    @ResponseBody
    public Result update(Template template, Integer[] brandId, Integer[] specId, String[] attribute) throws JsonProcessingException {
        List<JsonBean> jsonBeanList = new ArrayList<>();
        for (Integer bId : brandId) {
            JsonBean jsonBean = new JsonBean();
            String name = brandService.getBrandById(bId).getName();
            jsonBean.setId(bId);
            jsonBean.setText(name);
            jsonBeanList.add(jsonBean);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBrand = objectMapper.writeValueAsString(jsonBeanList);

        List<JsonBean> jsonBeans = new ArrayList<>();
        for (Integer sId : specId) {
            JsonBean jsonBean = new JsonBean();
            String name = specService.getSpecById(sId).getSpecName();
            jsonBean.setId(sId);
            jsonBean.setText(name);
            jsonBeans.add(jsonBean);
        }
        String jsonSpec = objectMapper.writeValueAsString(jsonBeans);

        List<JsonText> jsonTextList = new ArrayList<>();
        for (String attr : attribute) {
            JsonText jsonText = new JsonText();
            jsonText.setText(attr);
            jsonTextList.add(jsonText);
        }
        String jsonAttr = objectMapper.writeValueAsString(jsonTextList);

        template.setSpecId(jsonSpec);
        template.setBrandId(jsonBrand);
        template.setAttribute(jsonAttr);
        int i = templateService.updateTemplate(template);
        if (i > 0) {
            return Result.success("成功！");
        }
        return Result.error("失败！");
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Template> getTemplates() {
        return templateService.getTemplates();
    }



}
