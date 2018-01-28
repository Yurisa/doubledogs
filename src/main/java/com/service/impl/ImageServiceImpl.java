package com.service.impl;

import com.dao.ImageDao;
import com.entity.Image;
import com.service.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yurisa on 2017/6/9.
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    ImageDao imageDao;
    @Override
    public List<Image> getimagelist(int f_id){
        List<Image> list =  imageDao.queryByf_id(f_id);
        return list;
    }

}
