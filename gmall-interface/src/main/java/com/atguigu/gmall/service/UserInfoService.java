package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    //查询用户所有信息
    List<UserInfo> findAll();

    //根据userId 查询用户地址列表
    List<UserAddress> getUserAddressList(String userId);

}
