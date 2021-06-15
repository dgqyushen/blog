package com.qian;

import com.qian.entity.Blog;
import com.qian.mapper.BlogMapper;
import com.qian.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;


@SpringBootTest
class BlogApplicationTests {

    @Autowired
    BlogMapper blogMapper;


    @Test
    void contextLoads() {
        int length;
        List<Blog> blogs = blogMapper.selectList(null);
        length = blogs.stream().mapToInt(e -> e.getBlogContent().length()).sum();
        System.out.println(length);


    }

}
