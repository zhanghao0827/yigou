package com.yigou.web.controller;

import com.yigou.common.entity.Spec;
import com.yigou.common.util.PageUtils;
import com.yigou.common.util.Result;
import com.yigou.web.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    SpecService specService;

    @GetMapping("/")
    public String get(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                      @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                      @RequestParam(defaultValue = "", required = false) String specName, Model model) {
        PageUtils<Spec> pageUtils = specService.getSpecList(pageIndex, pageSize, specName);
        model.addAttribute("pageUtils", pageUtils);
        model.addAttribute("specName", specName);
        return "spec";
    }

    @PostMapping("/")
    @ResponseBody
    public Result add(String specName, String[] optName, Integer[] order) {
        int i = specService.addSpec(specName, optName, order);
        if (i > 0) {
            return Result.success("成功！");
        }
        return Result.error("失败！");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Map<String, Object> getById(@PathVariable Integer id) {
        return specService.getById(id);
    }

    @PutMapping("/")
    @ResponseBody
    public Result update(Spec spec, String[] optName, Integer[] order) {
        int i = specService.update(spec, optName, order);
        if (i > 0) {
            return Result.success("成功！");
        }
        return Result.error("失败！");
    }

}
