package com.qian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private MinioUtil minioUtil;

    @RequestMapping("/ping")
    public String test(){
        return "pong";
    }

//    @RequestMapping("/upload")
//    public String test2(MultipartFile file) throws InvalidArgumentException, InvalidBucketNameException, InsufficientDataException, XmlPullParserException, ErrorResponseException, IOException, NoSuchAlgorithmException, NoResponseException, InvalidKeyException, InvalidResponseException, InternalException {
//        String s = minioUtil.uploadFileAndGetUrl(file);
//        return s;
//    }
}
