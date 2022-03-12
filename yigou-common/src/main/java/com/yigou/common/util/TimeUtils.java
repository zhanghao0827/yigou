package com.yigou.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: easygo
 * @BelongsPackage: com.easygo.utils
 * @Author: bruceliu
 * @QQ:1241488705
 * @CreateTime: 2020-04-22 11:28
 * @Description: TODO
 */
public class TimeUtils {

    public static String getNow(){
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return f.format(new Date());
    }
}
