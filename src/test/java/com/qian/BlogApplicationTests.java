package com.qian;

import com.qian.controller.BlogController;
import com.qian.mapper.CategoriesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
class BlogApplicationTests {

    @Autowired
    CategoriesMapper categoriesMapper;

    @Test
    void contextLoads() {
        List<String> all = categoriesMapper.getAll();
        all.forEach(System.out::println);



    }

}
