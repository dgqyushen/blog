package com.qian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qian.vo.ViewBlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ViewBlogMapper extends BaseMapper<ViewBlog> {
    List<ViewBlog> getAll();
}
