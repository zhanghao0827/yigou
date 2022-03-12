package com.yigou.web.controller;

import com.yigou.common.util.FastDFSClient;
import com.yigou.common.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

    @Value("${nginx.host}")
    String host;

    @PostMapping("/img")
    @ResponseBody
    public Result uploadImg(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            String uri = fastDFSClient.uploadFile(file.getBytes(), suffixName);
            String url = host + uri;
            return Result.success("文件上传成功！", url);
        } catch (Exception e) {
            return Result.error("文件上传失败！");
        }
    }


}
