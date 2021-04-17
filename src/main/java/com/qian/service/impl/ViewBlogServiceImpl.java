package com.qian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qian.mapper.ViewBlogMapper;
import com.qian.service.ViewBlogService;
import com.qian.vo.ViewBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewBlogServiceImpl extends ServiceImpl<ViewBlogMapper, ViewBlog> implements ViewBlogService {

    @Autowired
    private ViewBlogMapper viewBlogMapper;

    @Override
    public List<ViewBlog> getAll() {
        return viewBlogMapper.getAll();
    }
}
