package com.yigou.spec.service;

import com.yigou.common.entity.SpecOpt;

import java.util.List;

public interface SpecOptService {

    int addSpecOpt(SpecOpt specOpt);

    List<SpecOpt> getSpecOptBySpecId(Integer specId);
}
