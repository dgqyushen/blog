package com.qian.controller;

import com.qian.entity.Visit;
import com.qian.result.Result;
import com.qian.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/visitor")
public class    VisitorController {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = "/getVisNum",method = RequestMethod.GET)
    public int getVisNum(){
        return visitorService.getVisNum();
    }

    @RequestMapping(value = "/getVisitData", method = RequestMethod.GET)
    public Map<String,Object> getVisitData(){
        List<Visit> latestFive = visitorService.getLatestFive();
//        HashMap<String, Object> map = new HashMap<>();
//        for (Visit visit : latestFive) {
//
//        }
        return Result.returnResult(200,"成功获取最近的5天访客数据",latestFive);
    }
}
