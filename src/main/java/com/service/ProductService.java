package com.service;

import com.entity.Product;

import java.util.List;

/**
 * Created by Yurisa on 2017/6/7.
 */
public interface ProductService {
    public int getTotalProductNum();
    public int getTotalNumByType(String type);
    public int getTotalNumBySubtype(String subtype);
    public int getTotalNumTypeKeyword(String type,String keyword);
    public int getTotalNumSubtypeKeyword(String subtype,String keyword);
    public List<Product> getProductlist(int currnum);
    public List<Product>getProductlistByType(String type,int currnum);
    public List<Product> getProductlistBySubtype(String subtype,int currnum);
    public List<Product> getProductlistSortByPricelow(int currnum);
    public List<Product> getProductlistSortByPricehigh(int currnum);
    public List<Product> getProductlistSortBytime(int currnum);
    public List<Product> getProductlistByTypeTime(String type,int currnum);
    public List<Product> getProductlistByTypePricelow(String type,int currnum);
    public List<Product> getProductlistByTypePricehigh(String type,int currnum);
    public List<Product> getProductlistBySubTypeTime(String subtype,int currnum);
    public List<Product> getProductlistBySubTypePricelow(String subtype,int currnum);
    public List<Product> getProductlistBySubTypePricehigh(String subtype,int currnum);
    public void  insertFp(int f_id,int p_id);
    public Product getOneById(int f_id);
    public List<Product> getPersonCollection(int p_id,int currnum);
    public List<Product> getProductlistByTypeKeyword(String type,String keyword,int currnum);
    public List<Product> getProductlistBySubtypeKeyword(String subtype,String keyword,int currnum);
}
