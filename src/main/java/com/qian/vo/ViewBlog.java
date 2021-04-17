package com.qian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewBlog {
    private String blogTitle;
    private Integer blogId;
    private Date blogCreated;
}
