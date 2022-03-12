package com.yigou.spec.service;

import com.yigou.common.entity.Spec;

import java.util.List;
import java.util.Map;

public interface SpecService {

    int getTotalCount(Map<String,Object> map);

    List<Spec> getSpecList(Map<String,Object> map);

    int addSpec(Spec spec);

    int addSpecTx(String specName, String[] optName, Integer[] order);

    Spec getSpecById(Integer id);

    int updateSpec(Spec spec, String[] optName, Integer[] order);

    List<Spec> getSpecs();
}
