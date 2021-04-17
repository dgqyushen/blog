package com.qian.service;

public interface LikeService {
    int likeNumAdd(int blogId);
    int likeNumReduce(int blogId);
    int getLikeNumByBlogId(int blogId);
}
