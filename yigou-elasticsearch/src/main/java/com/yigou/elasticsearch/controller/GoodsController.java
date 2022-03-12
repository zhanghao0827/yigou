package com.yigou.elasticsearch.controller;

import com.yigou.common.entity.Goods;
import com.yigou.common.util.PageUtils;
import com.yigou.elasticsearch.repository.GoodsRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/es")
public class GoodsController {

    @Autowired
    GoodsRepository goodsRepository;

    @Qualifier("elasticsearchClient")
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @GetMapping("/")
    public PageUtils<Goods> page(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                 @RequestParam(defaultValue = "12", required = false) Integer pageSize,
                                 @RequestParam(defaultValue = "", required = false) String keyword) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(
                QueryBuilders.multiMatchQuery(keyword, "goodsName", "caption"))
//                .sort("id", SortOrder.ASC)   //排序
                .from(pageIndex - 1)
                .size(pageSize)
                .highlighter(new HighlightBuilder()  //高亮
                        .field("*")
                        .requireFieldMatch(false)
                        .preTags("<span style='color:red;'>")
                        .postTags("</span>"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();

        List<Goods> goodsList = new ArrayList<>();
        for (SearchHit hit : hits) {
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            Goods goods = new Goods();
            Map<String, Object> map = hit.getSourceAsMap();
            goods.setId(Integer.valueOf(map.get("id").toString()));
            if (highlightFields.containsKey("goodsName")) {
                goods.setGoodsName(highlightFields.get("goodsName").fragments()[0].toString());
            } else {
                goods.setGoodsName(map.get("goodsName").toString());
            }
            goods.setBrandId(Integer.valueOf(map.get("brandId").toString()));
            if (highlightFields.containsKey("caption")) {
                goods.setCaption(highlightFields.get("caption").fragments()[0].toString());
            } else {
                goods.setCaption(map.get("caption").toString());
            }
            goods.setSmallPic(map.get("smallPic").toString());
            goods.setPrice(Double.valueOf(map.get("price").toString()));
            goodsList.add(goods);
        }
        return new PageUtils<>(pageIndex, pageSize, (int) searchResponse.getHits().getTotalHits().value, goodsList);
    }

}
