package com.yigou.elasticsearch.repository;

import com.yigou.common.entity.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GoodsRepository extends ElasticsearchRepository<Goods,Integer> {


}
