package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.mapper.BlogMapper;
import com.qian.pojo.Blog;
import com.qian.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Blog> getAll() {
//        加了一层redis查询
//        List<Blog> redisBlogs = (List<Blog>) redisTemplate.opsForValue().get("blogs");
//        if (redisBlogs!=null){
//           return redisBlogs;
//        }
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("blog_top","blog_created");
        List<Blog> sqlBlogs = blogMapper.selectList(wrapper);
//        redisTemplate.opsForValue().set("blogs",sqlBlogs);
        return sqlBlogs;
    }

    @Override
    public List<Blog> getBlogsByContent(String content) {
//        目前查询只能使用sql查询
        return blogMapper.getBlogsByContent(content);
    }

    @Override
    public Date getBlogCreatedLatestDay() {
//        Date time = (Date) redisTemplate.opsForValue().get("latest_update_blog_time");
//        if (time!=null){
//            return time;
//        }
        Date blogCreatedLatestDay = blogMapper.getBlogCreatedLatestDay();
//        redisTemplate.opsForValue().set("latest_update_blog_time",blogCreatedLatestDay);
        return blogCreatedLatestDay;
    }

    @Override
    public Blog getOneById(Integer id) {
//        String queryBlogName = "blog_"+id;
//        Blog redisBlog = (Blog) redisTemplate.opsForValue().get(queryBlogName);
//        if (redisBlog!=null){
//            return redisBlog;
//        }
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_id",id);
        Blog blog = blogMapper.selectOne(wrapper);
//        redisTemplate.opsForValue().set(queryBlogName,blog);
        return blog;

    }
}
