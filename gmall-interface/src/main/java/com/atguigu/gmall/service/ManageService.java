package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ManageService {

    //查询所有的一级分类
    List<BaseCatalog1> getCatalog1();
    //根据一级Id查询二级分类
    List<BaseCatalog2> getCatalog2(String catalog1Id);
    //根据二级Id查询三级分类
    List<BaseCatalog3> getCatalog3(String catalog2Id);
    //根据三级分类Id 查询平台属性列表
    List<BaseAttrInfo> getAttrList(String catalog3Id);

    //保存平台属性，平台属性值
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);
    //根据平台属性名称id取得平台属性对象
    BaseAttrInfo getAttrInfo(String attrId);
    //根据三级分类Id查询SupInfo列表
    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);
}
