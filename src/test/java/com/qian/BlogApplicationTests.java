package com.qian;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qian.mapper.CategoriesMapper;
import com.qian.mapper.CommentMapper;
import com.qian.pojo.Categories;
import com.qian.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BlogApplicationTests {



    @Autowired
    private CategoriesMapper categoriesMapper;

    @Test
    void contextLoads() {
//        QueryWrapper<Categories> wrapper = new QueryWrapper<>();
//        wrapper.eq("categories_blog_id",1);
//        List<Categories> categories = categoriesMapper.selectList(wrapper);
//        for (Categories category : categories) {
//            System.out.println(category);
//        }
        List<String> all = categoriesMapper.getAll();
        System.out.println(all);



    }

}
