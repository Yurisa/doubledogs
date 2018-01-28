package com.dao.impl;

import com.dao.ProductDao;
import com.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurisa on 2017/6/7.
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final RowMapper<Product> productRowMapper = new BeanPropertyRowMapper<Product>(Product.class);

    public static final String baseColumn = " f_id,name,url,type,subtype,price,time,designer,range1,material";

    public static  final String baseColumn2 = " forniture.f_id,forniture.name,forniture.url,forniture.type,forniture.subtype,forniture.price,forniture.time,forniture.designer,forniture.range1,forniture.material";
    @Override
    public int queryTotalProductNum() {
        String sql = "select count(*) from forniture";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int queryTotalNumByType(String type) {
        String sql = "select count(*) from forniture where type=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{type});
    }

    @Override
    public int queryTotalNumBySubType(String subtype) {
        String sql = "select count(*) from forniture where subtype=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{subtype});
    }

    @Override
    public List<Product> queryList(int currnum) {
        String sql = "select " + baseColumn + " from forniture order by f_id desc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{currnum});
        return list;
    }

    @Override
    public List<Product> queryByType(String type, int currnum) {
        String sql = "select" + baseColumn + " from forniture where type=? limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{type, currnum});
        return list;
    }

    @Override
    public List<Product> queryBySubtype(String subtype, int currnum) {
        String sql = "select" + baseColumn + " from forniture where subtype=? limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{subtype, currnum});
        return list;
    }

    @Override
    public List<Product> querySortByPricelow(int currnum) {
        String sql = "select" + baseColumn + " from forniture order by price asc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{currnum});
        return list;
    }

    @Override
    public List<Product> querySortByPricehigh(int currnum) {
        String sql = "select" + baseColumn + " from forniture order by price desc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{currnum});
        return list;
    }

    @Override
    public List<Product> querySortByTime(int currnum) {
        String sql = "select" + baseColumn + " from forniture order by time desc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{currnum});
        return list;
    }

    @Override
    public void insertFp(int f_id, int p_id) {
        String sql = "insert into fp( f_id,p_id) values(?,?)";
        List list = new ArrayList();
        list.add(f_id);
        list.add(p_id);
        jdbcTemplate.update(sql, list.toArray());

    }
    @Override
    public List<Product> queryByTypeTime(String type,int currnum){
        String sql = "select" + baseColumn + " from forniture where type=? order by time desc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{type, currnum});
        return list;
    }
    @Override
    public List<Product> queryByTypePricelow(String type,int currnum){
        String sql = "select" + baseColumn + " from forniture where type=? order by price asc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{type, currnum});
        return list;
    }
    @Override
    public List<Product> queryByTypePricehigh(String type,int currnum){
        String sql = "select" + baseColumn + " from forniture where type=? order by price desc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{type, currnum});
        System.out.print(list.get(0).getF_id());
        return list;
    }
    @Override
    public List<Product> queryBySubTypeTime(String subtype,int currnum){
        String sql = "select" + baseColumn + " from forniture where subtype=? order by time desc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{subtype, currnum});
        return list;
    }
    @Override
    public List<Product> queryBySubTypePricelow(String subtype,int currnum){
        String sql = "select" + baseColumn + " from forniture where subtype=? order by price asc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{subtype, currnum});
        return list;
    }
    @Override
    public List<Product> queryBySubTypePricehigh(String subtype,int currnum){
        String sql = "select" + baseColumn + " from forniture where subtype=? order by price desc limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{subtype, currnum});
        return list;
    }
    @Override
    public Product queryOneById(int f_id){
        String sql = "select" + baseColumn + " from forniture where f_id=? limit 1";
        Product product = jdbcTemplate.queryForObject(sql, productRowMapper, new Object[]{f_id});
        return product;
    }
    @Override
    public List<Product> queryListByP_id(int p_id,int currnum){
        String sql = "select" + baseColumn2 + " from forniture,fp where forniture.f_id=fp.f_id and fp.p_id=? limit ?,4";
        List<Product> list = jdbcTemplate.query(sql, productRowMapper, new Object[]{p_id,currnum});
        return list;
    }

    @Override
    public List<Product> queryByTypeKeyword(String type,String keyword,int currnum){
        String sql= "select" + baseColumn + " from forniture where type=? and name like ? limit ?,4";
        keyword="%"+keyword+"%";
        List<Product> list =jdbcTemplate.query(sql,productRowMapper,new Object[]{type,keyword, currnum});
        return list;
    }

    @Override
    public List<Product> queryBySubtypeKeyword(String subtype,String keyword,int currnum){
        String sql= "select" + baseColumn + " from forniture where subtype=? and name like ? limit ?,4";
        keyword="%"+keyword+"%";
        List<Product> list =jdbcTemplate.query(sql,productRowMapper,new Object[]{subtype,keyword, currnum});
        return list;
    }
    @Override
    public  int qureyTotalNumByTypeKeyword(String type,String keyword){
        String sql = "select count(*) from forniture where type=? and name like ?";
        keyword="%"+keyword+"%";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{type,keyword});
    }
    @Override
    public  int qureyTotalNumBySubtypeKeyword(String subtype,String keyword){
        String sql = "select count(*) from forniture where subtype=? and name like ?";
        keyword="%"+keyword+"%";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{subtype,keyword});
    }
}
