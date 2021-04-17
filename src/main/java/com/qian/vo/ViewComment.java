package com.qian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewComment {

    private String commentAuthor;
    private String commentContent;
    private Integer commentBlogId;

}
