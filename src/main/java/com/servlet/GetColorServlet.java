package com.servlet;

import com.entity.Color;
import com.service.ColorService;
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
@WebServlet("/getcolor")
public class GetColorServlet extends AutowiredHttpServlet{
    @Autowired
    private ColorService colorservice;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int f_id = Integer.parseInt(request.getParameter("f_id"));
        List<Color> colorlist = colorservice.getcolorlist(f_id);
        JSONArray json = new JSONArray();
        for(Color col : colorlist){
            JSONObject color = new JSONObject(col);
            json.put(color);
        }
        JSONObject jcolor = new JSONObject();
        jcolor.put("colorJsonList",json);
        responseJSON(response,jcolor.toString());

    }
}
