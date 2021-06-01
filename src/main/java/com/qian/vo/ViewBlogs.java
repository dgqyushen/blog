package com.qian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewBlogs {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String image;
    private Boolean isTop;
}
