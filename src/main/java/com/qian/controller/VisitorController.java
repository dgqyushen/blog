package com.qian.controller;

import com.qian.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = "/getVisNum",method = RequestMethod.GET)
    public int getVisNum(){
        return visitorService.getVisNum();
    }
}
