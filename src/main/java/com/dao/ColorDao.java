package com.dao;

import com.entity.Color;

import java.util.List;

/**
 * Created by Yurisa on 2017/6/9.
 */
public interface ColorDao {
    public List<Color> queryById(int f_id);
}
