package com.qian.controller;

import com.qian.util.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    @Autowired
    private OSSUtil ossUtil;

    @RequestMapping("/upload")
    public String uploadFile(MultipartFile file) throws IOException {
        String url = ossUtil.getFileUrl(file);
        return url;
    }

}
