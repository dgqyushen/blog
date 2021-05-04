package com.qian.service.impl;

import com.qian.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Integer getVisNum() {
        Integer num = (Integer) redisTemplate.opsForValue().get("visitor_num");
        if (num == null){
            redisTemplate.opsForValue().set("visitor_num",1);
            return 1;
        }
        return num;
    }
}
