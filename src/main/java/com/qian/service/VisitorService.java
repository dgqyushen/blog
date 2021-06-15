package com.qian.service;

import com.qian.entity.Visit;

import java.util.List;

public interface VisitorService {
    Integer getVisNum();
    List<Visit> getLatestFive();
}
