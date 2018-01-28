package com.dao;

import com.entity.Image;

import java.util.List;

/**
 * Created by Yurisa on 2017/6/9.
 */
public interface ImageDao {
    public List<Image> queryByf_id(int f_id);
}
