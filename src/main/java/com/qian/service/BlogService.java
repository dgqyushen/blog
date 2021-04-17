package com.qian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qian.pojo.Blog;

import java.sql.Date;
import java.util.List;

public interface BlogService extends IService<Blog> {
    List<Blog> getAll();

    List<Blog> getBlogsByContent(String content);

    Date getBlogCreatedLatestDay();

    Blog getOneById(Integer id);

}
