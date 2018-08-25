package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;

import java.util.List;

public interface UserAddressService {

    //根据userId 查询用户地址列表
    List<UserAddress> findByUserId(String userId);

}
