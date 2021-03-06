package com.atguigu.gmall.usermanage.controler;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@ResponseBody 返回Json字符串，将数据显示在页面上
@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> getAll(){
        return userInfoService.findAll();
    }
}

