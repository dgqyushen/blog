package com.qian.service.impl;



import com.qian.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int likeNumAdd(int blogId) {
        String query = "blog_like_num"+blogId;
        Integer likeNum = (Integer) redisTemplate.opsForValue().get(query);
        if (likeNum==null){
            redisTemplate.opsForValue().set(query,1);
            return -1;
        }
        redisTemplate.opsForValue().increment(query,1);
        return 0;
    }

    @Override
    public int likeNumReduce(int blogId) {
        String query = "blog_like_num"+blogId;
        redisTemplate.opsForValue().decrement(query,1);
        return 0;
    }

    @Override
    public int getLikeNumByBlogId(int blogId) {
        String query = "blog_like_num"+blogId;
        Integer result = (Integer) redisTemplate.opsForValue().get(query);
        if (result==null){
            redisTemplate.opsForValue().set(query,0);
            return 0;
        }
        return result;
    }
}
