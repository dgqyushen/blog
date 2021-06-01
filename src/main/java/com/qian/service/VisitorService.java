package com.qian.service;

import com.qian.pojo.Visit;

import java.util.List;

public interface VisitorService {
    Integer getVisNum();
    List<Visit> getLatestFive();
}
