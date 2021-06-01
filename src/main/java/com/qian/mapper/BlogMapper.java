package com.qian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qian.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    List<Blog> getBlogsByContent(String content);

    Date getBlogCreatedLatestDay();

    List<Blog> getLatestFiveBlogsNameAndVisNum();

    List<Blog> getBlogsInfo();




}
