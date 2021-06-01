package com.qian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qian.pojo.Blog;
import com.qian.vo.ViewBlogs;

import java.sql.Date;
import java.util.List;

public interface BlogService extends IService<Blog> {
    List<Blog> getAll();

    List<Blog> getBlogsByContent(String content);

    Date getBlogCreatedLatestDay();

    Blog getOneById(Integer id);

    List<Blog> getLatestFiveBlogsNameAndVisNum();

    int saveBlog(ViewBlogs viewBlogs);

    List<Blog> getBlogsInfo();

    int changeBlogTopByBlogId(Boolean top,Integer blogId);

    int deleteBlogById(Integer id);

    int updateBlog(ViewBlogs viewBlogs);

    int deleteBlogsById(int[] blogIdList);
}
