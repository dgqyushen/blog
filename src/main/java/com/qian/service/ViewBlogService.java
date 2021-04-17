package com.qian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qian.vo.ViewBlog;

import java.util.List;

public interface ViewBlogService extends IService<ViewBlog> {
    List<ViewBlog> getAll();
}
