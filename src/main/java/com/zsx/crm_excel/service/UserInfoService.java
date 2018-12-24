package com.zsx.crm_excel.service;

import com.zsx.crm_excel.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {

    //获取所有用户信息
    List<UserInfo> getUserInfoAll();

    //按照日期获取用户信息
    List<UserInfo> getUserInfoByTime(String beginDate,String endDate);
}
