package com.qian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/*
*
* 这个后面要重新修改，对应的是前端的blog-vue项目，以后写完后要修改
*
*
*
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewBlog {
    private String blogTitle;
    private Integer blogId;
    private Date blogCreated;
}
