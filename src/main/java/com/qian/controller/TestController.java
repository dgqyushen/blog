package com.qian.controller;

import com.qian.util.IPUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
//@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private MinioUtil minioUtil;

    @RequestMapping("/ping")
    public String test(){
        return "pong";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/update")
    public String update(){
        return "update";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }

    @RequestMapping("/getIP")
    public String getIP(HttpServletRequest httpServletRequest) throws IOException {
        String ipAddress = IPUtil.getIPAddress(httpServletRequest);
        return ipAddress;
    }





//    @RequestMapping("/upload")
//    public String test2(MultipartFile file) throws InvalidArgumentException, InvalidBucketNameException, InsufficientDataException, XmlPullParserException, ErrorResponseException, IOException, NoSuchAlgorithmException, NoResponseException, InvalidKeyException, InvalidResponseException, InternalException {
//        String s = minioUtil.uploadFileAndGetUrl(file);
//        return s;
//    }
}
