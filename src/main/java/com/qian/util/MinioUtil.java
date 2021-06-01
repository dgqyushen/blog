package com.qian.util;

import com.qian.config.MinioConfig;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component
public class MinioUtil {
    @Autowired
    private MinioClient minioClient;

    private String bucket = "blog-images";

    public String uploadFileAndGetUrl(MultipartFile file) throws IOException, InvalidBucketNameException, InsufficientDataException, XmlPullParserException, ErrorResponseException, NoSuchAlgorithmException, NoResponseException, InvalidKeyException, InvalidResponseException, InternalException, InvalidArgumentException {
        if (file.isEmpty() || file.getSize() == 0) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        String newName = "pic/" + UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
        InputStream inputStream = file.getInputStream();
        minioClient.putObject(bucket, newName, inputStream, "application/octet-stream");
        inputStream.close();
        String url = minioClient.getObjectUrl(bucket, newName);
        return url;

    }
}
