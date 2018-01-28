package com.dao;

import com.entity.Product;

import java.util.List;

/**
 * Created by Yurisa on 2017/6/7.
 */
public interface ProductDao {
    public  int queryTotalProductNum();
    public  int queryTotalNumByType(String type);
    public  int queryTotalNumBySubType(String subtype);
    public  int qureyTotalNumByTypeKeyword(String type,String keyword);
    public  int qureyTotalNumBySubtypeKeyword(String subtype,String keyword);
    public List<Product> queryList(int currnum);
    public List<Product> queryByType(String type,int currnum);
    public List<Product> queryByTypeTime(String type,int currnum);
    public List<Product> queryByTypePricelow(String type,int currnum);
    public List<Product> queryByTypePricehigh(String type,int currnum);
    public List<Product> queryBySubTypeTime(String subtype,int currnum);
    public List<Product> queryBySubTypePricelow(String subtype,int currnum);
    public List<Product> queryBySubTypePricehigh(String subtype,int currnum);
    public  List<Product> queryBySubtype(String subtype,int currnum);
    public  List<Product> querySortByPricelow(int currnum);
    public  List<Product>  querySortByPricehigh(int currnum);
    public List<Product> querySortByTime(int currnum);
    public Product queryOneById(int f_id);
    public  void insertFp(int f_id,int p_id);
    public List<Product> queryListByP_id(int p_id,int currnum);
    public List<Product> queryByTypeKeyword(String type,String keyword,int currnum);
    public List<Product> queryBySubtypeKeyword(String subtype,String keyword,int currnum);
}
