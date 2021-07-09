package com.qian.util;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@Data
public class OSSUtil {

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Autowired
    private OSSClient ossClient;

    public String getFileUrl(MultipartFile file) throws IOException {
        if (file.isEmpty()||file.getSize()==0){
            return null;
        }
        String fileName = file.getOriginalFilename();
        String newName = "cover-pic/" + UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
//        System.out.println(newName);
//        ossClient.putObject()
        ossClient.putObject(bucketName,newName,file.getInputStream());
        String url = "https://dgqyushen-blog-images.oss-cn-beijing.aliyuncs.com/"+newName;
//        System.out.println(url);
        return url;



    }





}
