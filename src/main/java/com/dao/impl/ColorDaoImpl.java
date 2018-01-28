package com.dao.impl;

import com.dao.ColorDao;
import com.entity.Color;
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
@Repository("colorDao")
public class ColorDaoImpl implements ColorDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final RowMapper<Color> colorRowMapper = new BeanPropertyRowMapper<Color>(Color.class);

    @Override
    public List<Color> queryById(int f_id){
        String sql = "select * from Color where f_id=? order by f_id desc";
        List<Color> list = jdbcTemplate.query(sql, colorRowMapper, new Object[]{f_id});
        return list;
    }
}
