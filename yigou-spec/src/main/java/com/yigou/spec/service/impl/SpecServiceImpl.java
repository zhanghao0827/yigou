package com.yigou.spec.service.impl;

import com.yigou.common.entity.Spec;
import com.yigou.common.entity.SpecOpt;
import com.yigou.spec.mapper.SpecMapper;
import com.yigou.spec.mapper.SpecOptMapper;
import com.yigou.spec.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    SpecMapper specMapper;

    @Autowired
    SpecOptMapper specOptMapper;

    @Override
    public int getTotalCount(Map<String, Object> map) {
        return specMapper.getTotalCount(map);
    }

    @Override
    public List<Spec> getSpecList(Map<String, Object> map) {
        return specMapper.getSpecList(map);
    }

    @Override
    public int addSpec(Spec spec) {
        return specMapper.addSpec(spec);
    }

    @Override
    @Transactional
    public int addSpecTx(String specName, String[] optName, Integer[] order) {
        Spec spec = new Spec();
        spec.setSpecName(specName);
        specMapper.addSpec(spec);
        for (int i = 0; i < optName.length; i++) {
            SpecOpt specOpt = new SpecOpt();
            specOpt.setSpecId(spec.getId());
            specOpt.setOptName(optName[i]);
            specOpt.setOrder(order[i]);
            specOptMapper.addSpecOpt(specOpt);
        }
        return 1;
    }

    @Override
    public Spec getSpecById(Integer id) {
        return specMapper.getSpecById(id);
    }

    @Override
    @Transactional
    public int updateSpec(Spec spec, String[] optName, Integer[] order) {
        specMapper.updateSpec(spec);
        specOptMapper.deleteSpecOptBySpecId(spec.getId());
        for (int i = 0; i < optName.length; i++) {
            SpecOpt specOpt = new SpecOpt();
            specOpt.setSpecId(spec.getId());
            specOpt.setOptName(optName[i]);
            specOpt.setOrder(order[i]);
            specOptMapper.addSpecOpt(specOpt);
        }
        return 1;
    }

    @Override
    public List<Spec> getSpecs() {
        return specMapper.getSpecs();
    }
}
