package com.service.impl;

import com.dao.ColorDao;
import com.entity.Color;
import com.service.ColorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yurisa on 2017/6/9.
 */
@Service("colorService")
public class ColorServiceImpl implements ColorService{
    @Resource
    ColorDao colorDao;
    @Override
    public List<Color> getcolorlist(int f_id){
        List<Color> list = colorDao.queryById(f_id);
        return list;
    }
}
