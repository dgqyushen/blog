package com.qian;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.qian.config.OssConfig;
import com.qian.entity.Blog;
import com.qian.mapper.BlogMapper;
import com.qian.mapper.RoleMapper;
import com.qian.util.OSSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
class BlogApplicationTests {

//    @Autowired
//    OSSClient ossClient;
    @Autowired
    OssConfig ossConfig;

    @Autowired
    OSSUtil ossUtil;

//    String bucketName = "dgqyushen-blog-images";
//    String objectName = "content-pic/Test2";
//    String content = "Hello OSS";

    @Test
    void contextLoads() {
//        PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
//        String eTag = putObjectResult.get
//        System.out.println(ossConfig);
        System.out.println(ossUtil);


    }

}
