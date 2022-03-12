package com.yigou.elasticsearch;

import com.yigou.common.entity.Goods;
import com.yigou.elasticsearch.repository.GoodsRepository;
import com.yigou.elasticsearch.service.GoodsService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class ElasticsearchTests {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsService goodsService;

    @Qualifier("elasticsearchClient")
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test

    public void test() {
        List<Goods> goods = goodsService.getAllGood(1);
        for (Goods good : goods) {
            goodsRepository.save(good);
        }
    }

    @Test
    public void test2() {
        Optional<Goods> goods = goodsRepository.findById(1);
        System.out.println(goods.get());
    }

    @Test
    public void test4() {
        long count = goodsRepository.count();
        System.out.println(count);
    }

    @Test
    public void test3() throws IOException {
        int pageIndex = 1;
        int pageSize = 5;
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(
                QueryBuilders.multiMatchQuery("手机", "goodsName", "caption"))
//                .sort("id", SortOrder.ASC)   //排序
                .from(pageIndex - 1)
                .size(pageSize);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();

        List<Goods> goodsList = new ArrayList<>();
        for (SearchHit hit : hits) {
            Goods goods = new Goods();
            Map<String, Object> map = hit.getSourceAsMap();
            goods.setId(Integer.valueOf(map.get("id").toString()));
            goods.setGoodsName(map.get("goodsName").toString());
            goods.setBrandId(Integer.valueOf(map.get("brandId").toString()));
            goods.setCaption(map.get("caption").toString());
            goods.setSmallPic(map.get("smallPic").toString());
            goods.setPrice(Double.valueOf(map.get("price").toString()));
            goodsList.add(goods);
        }
        goodsList.forEach(System.out::println);
    }

    @Test
    public void test5() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(
                QueryBuilders.multiMatchQuery("手机", "goodsName", "caption"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        long value = searchResponse.getHits().getTotalHits().value;
        System.out.println(value);
    }

    @Test
    public void test6() throws IOException {
        int pageIndex = 1;
        int pageSize = 5;
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(
                QueryBuilders.multiMatchQuery("手机", "goodsName", "caption"))
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
        goodsList.forEach(System.out::println);
    }
}
