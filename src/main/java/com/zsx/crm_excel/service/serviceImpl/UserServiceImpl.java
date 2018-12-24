package com.zsx.crm_excel.service.serviceImpl;

import com.zsx.crm_excel.mapper.UserInfoMapper;
import com.zsx.crm_excel.pojo.UserInfo;
import com.zsx.crm_excel.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserInfoAll() {
        return userInfoMapper.getUserInfo();
    }

    @Override
    public List<UserInfo> getUserInfoByTime(String beginDate, String endDate) {
        System.out.println(beginDate + endDate );
        return userInfoMapper.getUserInfoByTime(beginDate,endDate);
    }
}
