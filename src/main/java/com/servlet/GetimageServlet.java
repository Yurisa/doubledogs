package com.servlet;

import com.entity.Image;
import com.service.ImageService;;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yurisa on 2017/6/9.
 */
@WebServlet("/getimage")
public class GetimageServlet extends AutowiredHttpServlet {
    @Autowired
    private ImageService imageservice;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int f_id = Integer.parseInt(request.getParameter("f_id"));
        List<Image> imagelist = imageservice.getimagelist(f_id);
        JSONArray json = new JSONArray();
        for(Image img : imagelist){
            JSONObject image = new JSONObject(img);
            json.put(image);
        }
        JSONObject jimage = new JSONObject();
        jimage.put("imageJsonList",json);
        responseJSON(response,jimage.toString());

    }
}
