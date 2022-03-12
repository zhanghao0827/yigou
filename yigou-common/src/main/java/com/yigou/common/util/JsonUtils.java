package com.yigou.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yigou.common.bean.AttrBean;
import com.yigou.common.bean.JsonBean;
import com.yigou.common.bean.OrderUrlBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: easygo
 * @BelongsPackage: com.easygo.utils
 * @Author: bruceliu
 * @QQ:1241488705
 * @CreateTime: 2020-04-03 10:20
 * @Description: Json解析工具类
 */
public class JsonUtils {

    //原字符串：[{"id":23,"text":"美特斯邦威"},{"id":24,"text":"森马"},{"id":32,"text":"阿迪达斯"},{"id":42,"text":"花花公子"}]
    //结果: 美特斯邦威,森马,阿迪达斯,花花公子
    public static String parseJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuffer sb = new StringBuffer();
        try {
            List<JsonBean> brandObjects = objectMapper.readValue(json, new TypeReference<ArrayList<JsonBean>>() {
            });
            for (JsonBean brandObject : brandObjects) {
                if (brandObject != null) {
                    String text = brandObject.getText();
                    sb.append(text + ",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = sb.toString();
        s = s.substring(0, s.length() - 1);
        return s;
    }

    public static List<JsonBean> parseJson2List(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonBean> list = null;
        try {
            list = objectMapper.readValue(json, new TypeReference<ArrayList<JsonBean>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<OrderUrlBean> parseJson2ListByOrderUrl(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OrderUrlBean> list = null;
        try {
            list = objectMapper.readValue(json, new TypeReference<ArrayList<OrderUrlBean>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<AttrBean> parseJson2ListByAttr(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<AttrBean> list = null;
        try {
            list = objectMapper.readValue(json, new TypeReference<ArrayList<AttrBean>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<String, Object> parseJson2Map(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = null;
        try {
            map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


}

