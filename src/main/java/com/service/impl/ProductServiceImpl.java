package com.service.impl;

import com.dao.ProductDao;
import com.entity.Product;
import com.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yurisa on 2017/6/7.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Resource
    ProductDao productDao;
    @Override
    public  int getTotalProductNum(){
        return productDao.queryTotalProductNum();
    }
    @Override
    public int getTotalNumByType(String type){
        return productDao.queryTotalNumByType(type);
    }
    @Override
    public int getTotalNumBySubtype(String subtype){
        return productDao.queryTotalNumBySubType(subtype);
    }
    @Override
    public List<Product> getProductlist(int currnum) {
        return productDao.queryList(currnum);
    }
    @Override
   public List<Product>getProductlistByType(String type,int currnum){
        return productDao.queryByType(type,currnum);
    }
    @Override
   public List<Product> getProductlistBySubtype(String subtype,int currnum){
        return  productDao.queryBySubtype(subtype,currnum);
    }
    @Override
    public List<Product> getProductlistSortByPricelow(int currnum){
        return  productDao.querySortByPricelow(currnum);
    }
    @Override
    public List<Product> getProductlistSortByPricehigh(int currnum){
        return productDao.querySortByPricehigh(currnum);
    }
    @Override
    public List<Product> getProductlistSortBytime(int currnum){
        return productDao.querySortByTime(currnum);
    }
    @Override
    public void insertFp(int f_id,int p_id){
        productDao.insertFp(f_id,p_id);
    }
    @Override
    public Product getOneById(int f_id){
        return productDao.queryOneById(f_id);
    }
    @Override
    public List<Product> getProductlistByTypeTime(String type,int currnum){
        return productDao.queryByTypeTime(type,currnum);
    }
    @Override
    public List<Product> getProductlistByTypePricelow(String type,int currnum){
        return  productDao.queryByTypePricelow(type,currnum);
    }
    @Override
    public List<Product> getProductlistByTypePricehigh(String type,int currnum){
        return  productDao.queryByTypePricehigh(type,currnum);
    }
    @Override
    public List<Product> getProductlistBySubTypeTime(String subtype,int currnum){
       return  productDao.queryBySubTypeTime(subtype,currnum);
    }
    @Override
    public List<Product> getProductlistBySubTypePricelow(String subtype,int currnum){
       return  productDao.queryBySubTypePricelow(subtype,currnum);
    }
    @Override
    public List<Product> getProductlistBySubTypePricehigh(String subtype,int currnum){
      return productDao.queryBySubTypePricehigh(subtype,currnum);
    }
    @Override
    public List<Product> getPersonCollection(int p_id,int currnum){
        return productDao.queryListByP_id(p_id,currnum);
    }
    @Override
    public List<Product> getProductlistByTypeKeyword(String type,String keyword,int currnum){
        return  productDao.queryByTypeKeyword(type,keyword,currnum);
    }
    @Override
    public List<Product> getProductlistBySubtypeKeyword(String subtype,String keyword,int currnum){
        return  productDao.queryBySubtypeKeyword(subtype,keyword,currnum);
    }
    @Override
    public int getTotalNumTypeKeyword(String type,String keyword){
        return  productDao.qureyTotalNumByTypeKeyword(type,keyword);
    }
    @Override
    public int getTotalNumSubtypeKeyword(String subtype,String keyword){
       return productDao.qureyTotalNumBySubtypeKeyword(subtype,keyword);
    }
}
