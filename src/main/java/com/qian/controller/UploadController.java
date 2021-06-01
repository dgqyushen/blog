package com.qian.controller;

import com.qian.util.MinioUtil;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class UploadController {
    @Autowired
    private MinioUtil minioUtil;

    @RequestMapping("/upload")
    public String uploadFile(MultipartFile file) throws InvalidArgumentException, InvalidBucketNameException, InsufficientDataException, XmlPullParserException, ErrorResponseException, IOException, NoSuchAlgorithmException, NoResponseException, InvalidKeyException, InvalidResponseException, InternalException {
        String url = minioUtil.uploadFileAndGetUrl(file);
        return url;
    }

}
