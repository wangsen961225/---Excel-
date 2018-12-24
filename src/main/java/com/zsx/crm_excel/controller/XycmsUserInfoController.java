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
import java.util.List;

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

    @RequestMapping(value = "/userInfoByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<UserInfo> getUserInfoByTime(String beginDate,String endDate){
        List<UserInfo> userInfoList = userInfoService.getUserInfoByTime(beginDate, endDate);
        return userInfoList;
    }
}
