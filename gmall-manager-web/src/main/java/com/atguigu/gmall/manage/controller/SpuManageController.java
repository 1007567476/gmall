package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.BaseSaleAttr;
import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpuManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("spuListPage")
    public String spuListPage(){
        return "spuListPage";
    }

    //select * from supInfo where catalog3Id=?
     @RequestMapping("spuList")
     @ResponseBody
    public List<SpuInfo> spuList(String catalog3Id){
        //调用后台
         SpuInfo supInfo =  new SpuInfo();
         supInfo.setCatalog3Id(catalog3Id);
        return  manageService.getSpuInfoList(supInfo);
    }


    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> getBaseSaleAttrList(){
        //调用service层
       return  manageService.getBaseSaleAttrList();

    }

    @RequestMapping(value = "saveSpuInfo",method = RequestMethod.POST)
    @ResponseBody
    public String saveSpuInfo(SpuInfo spuInfo){
       manageService.saveSpuInfo(spuInfo);
        return  "success";
    }


}
