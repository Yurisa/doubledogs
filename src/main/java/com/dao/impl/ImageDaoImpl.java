package com.dao.impl;

import com.dao.ImageDao;
import com.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yurisa on 2017/6/9.
 */
@Repository("imageDao")
public class ImageDaoImpl implements ImageDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final RowMapper<Image> imageRowMapper = new BeanPropertyRowMapper<Image>(Image.class);
    @Override
    public List<Image> queryByf_id(int f_id){
        String sql = "select * from image where f_id=? order by f_id desc";
        List<Image> list = jdbcTemplate.query(sql, imageRowMapper, new Object[]{f_id});
        return list;
    }

}
