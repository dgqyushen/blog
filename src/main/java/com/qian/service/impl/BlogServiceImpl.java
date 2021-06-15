package com.qian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.dto.SimpleBlogDTO;
import com.qian.mapper.BlogMapper;
import com.qian.mapper.CategoriesMapper;
import com.qian.entity.Blog;
import com.qian.entity.Categories;
import com.qian.service.BlogService;
import com.qian.vo.ViewBlogs;
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

    @Autowired
    CategoriesMapper categoriesMapper;

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

    @Override
    public List<Blog> getLatestFiveBlogsNameAndVisNum() {
        return blogMapper.getLatestFiveBlogsNameAndVisNum();
    }

    @Override
    public int saveBlog(ViewBlogs viewBlogs) {
//        String author = viewBlogs.getAuthor();
//        String content = viewBlogs.getContent();
//        String title = viewBlogs.getTitle();
//        String image = viewBlogs.getImage();
//        return blogMapper.insert(new Blog(null,title,content,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),image,author,viewBlogs.getIsTop(),null));
//        System.out.println(viewBlogs);
//        return 1;
        return blogMapper.insert(new Blog(null,viewBlogs.getTitle(),viewBlogs.getContent(),new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),viewBlogs.getImage(),viewBlogs.getAuthor(),viewBlogs.getIsTop(),null,null,null,null,null,null));
    }

    @Override
    public List<Blog> getBlogsInfo() {
        List<Blog> blogsInfo = blogMapper.getBlogsInfo();
        blogsInfo.forEach(e->{
//            从redis数据库中查找
            if (redisTemplate.opsForValue().get("blog_like_num" + e.getBlogId().toString())==null){
                redisTemplate.opsForValue().set("blog_like_num" + e.getBlogId().toString(),0);
                redisTemplate.opsForValue().set("blog_visit_num"+e.getBlogId().toString(),0);
                e.setLikeNum(0);
                e.setVisitNum(0);
            }else {
                e.setLikeNum((Integer) redisTemplate.opsForValue().get("blog_like_num" + e.getBlogId().toString()));
                e.setVisitNum((Integer) redisTemplate.opsForValue().get("blog_visit_num" + e.getBlogId().toString()));
            }
        });
        return blogsInfo;
    }

    @Override
    public int changeBlogTopByBlogId(Boolean top, Integer blogId) {
        Blog blog = new Blog();
        blog.setBlogTop(top);
        blog.setBlogId(blogId);
        return blogMapper.updateById(blog);
    }

    @Override
    public int deleteBlogById(Integer id) {
        QueryWrapper<Categories> categoriesQueryWrapper = new QueryWrapper<>();
        categoriesQueryWrapper.eq("categories_blog_id",id);
        categoriesMapper.delete(categoriesQueryWrapper);
        return blogMapper.deleteById(id);

    }

    @Override
    public int updateBlog(ViewBlogs viewBlogs) {
        return blogMapper.updateById(new Blog(viewBlogs.getId(), viewBlogs.getTitle(), viewBlogs.getContent(), null,new Date(System.currentTimeMillis()), viewBlogs.getImage(), viewBlogs.getAuthor(), viewBlogs.getIsTop(),null,null,null,null,null,0));
    }

    @Override
    public int deleteBlogsById(int[] blogIdList) {
        for (int i : blogIdList) {
            deleteBlogById(i);
        }
        return 0;
    }

    @Override
    public List<SimpleBlogDTO> getSimpleBlog() {
        return blogMapper.getAll();
    }

    @Override
    public int getAllBlogsCharacterAccount() {
        List<Blog> blogs = blogMapper.selectList(null);
        return blogs.stream().mapToInt(e -> e.getBlogContent().length()).sum();
    }
}
