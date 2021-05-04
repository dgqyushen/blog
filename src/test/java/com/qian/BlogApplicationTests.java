package com.qian;

import com.qian.service.VisitorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BlogApplicationTests {


    @Autowired
    VisitorService visitorService;

    @Test
    void contextLoads() {

        Integer visNum = visitorService.getVisNum();
        System.out.println(visNum);



    }

}
