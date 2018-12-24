package com.zsx.crm_excel.mapper;

import com.zsx.crm_excel.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    //获取所有用户信息
    List<UserInfo> getUserInfo();

    //根据日期获取用户信息
    List<UserInfo> getUserInfoByTime(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
}
