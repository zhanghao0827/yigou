package com.yigou.web.service;

import com.yigou.common.entity.Spec;
import com.yigou.common.util.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("yigou-spec")
public interface SpecService {

    @GetMapping("/spec/")
    PageUtils<Spec> getSpecList(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                @RequestParam(defaultValue = "5", required = false) Integer pageSize, @RequestParam String specName);

    @PostMapping("/spec/")
    int addSpec(@RequestParam String specName, @RequestParam String[] optName, @RequestParam Integer[] order);

    @GetMapping("/spec/{id}")
    Map<String, Object> getById(@PathVariable Integer id);

    @PutMapping("/spec/")
    int update(@RequestBody Spec spec, @RequestParam String[] optName, @RequestParam Integer[] order);

    @GetMapping("/spec/all")
    List<Spec> getSpecs();

    @GetMapping("/spec/getSpec/{id}")
    Spec getSpecById(@PathVariable Integer id);
}
