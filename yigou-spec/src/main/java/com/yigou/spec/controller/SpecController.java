package com.yigou.spec.controller;

import com.yigou.common.entity.Spec;
import com.yigou.common.entity.SpecOpt;
import com.yigou.common.util.PageUtils;
import com.yigou.spec.service.SpecOptService;
import com.yigou.spec.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    SpecService specService;

    @Autowired
    SpecOptService specOptService;

    @GetMapping("/")
    public PageUtils<Spec> getSpecList(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                       @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                       @RequestParam(defaultValue = "", required = false) String specName) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageIndex", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("specName", specName);
        int totalCount = specService.getTotalCount(map);
        List<Spec> specList = specService.getSpecList(map);
        return new PageUtils<>(pageIndex, pageSize, totalCount, specList);
    }

    @PostMapping("/")
    public int addSpec(String specName, String[] optName, Integer[] order) {
        int i;
        try {
            i = specService.addSpecTx(specName, optName, order);
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable Integer id) {
        Spec spec = specService.getSpecById(id);
        List<SpecOpt> specOpts = specOptService.getSpecOptBySpecId(spec.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("spec", spec);
        map.put("specOpts", specOpts);
        return map;
    }

    @GetMapping("/getSpec/{id}")
    public Spec getSpecById(@PathVariable Integer id) {
        return specService.getSpecById(id);
    }

    @PutMapping("/")
    public int update(@RequestBody Spec spec, String[] optName, Integer[] order) {
        return specService.updateSpec(spec, optName, order);
    }

    @GetMapping("/all")
    public List<Spec> getSpecs() {
        return specService.getSpecs();
    }

}
