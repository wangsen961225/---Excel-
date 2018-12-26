package com.zsx.crm_excel.controller;

import com.zsx.crm_excel.pojo.UserInfo;
import com.zsx.crm_excel.service.UserInfoService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class XycmsUserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<UserInfo> getUserInfo(){
        List<UserInfo> userInfoList = userInfoService.getUserInfoAll();
        return userInfoList;
    }

    @RequestMapping(value = "/userInfoByTime")
    @ResponseBody
    public List<UserInfo> getUserInfoByTime(String beginDate,String endDate){
        List<UserInfo> userInfoList = userInfoService.getUserInfoByTime(beginDate, endDate);
        return userInfoList;
    }

    @RequestMapping(value = "/userInfoCountByTime")
    @ResponseBody
    public Map getUserInfoCountByTime(String beginDate, String endDate){
        Integer count = userInfoService.getUserInfoCountByTime(beginDate, endDate);
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println(beginDate+"---"+endDate);
        map.put("beginDate",beginDate);
        map.put("endDate",endDate);
        map.put("count",count);
        return map;
    }
}
