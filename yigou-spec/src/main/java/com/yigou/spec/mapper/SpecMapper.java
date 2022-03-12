package com.yigou.spec.mapper;

import com.yigou.common.entity.Spec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SpecMapper {

    int getTotalCount(Map<String, Object> map);

    List<Spec> getSpecList(Map<String, Object> map);

    int addSpec(Spec spec);

    Spec getSpecById(Integer id);

    int updateSpec(Spec spec);

    List<Spec> getSpecs();
}
