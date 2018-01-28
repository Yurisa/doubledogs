package com.servlet;

import com.entity.Product;
import com.service.ProductService;
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
@WebServlet("/product_detail")
public class OneproductServlet extends AutowiredHttpServlet{
    @Autowired
    private ProductService productservice;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int f_id = Integer.parseInt(request.getParameter("f_id"));
        Product product = productservice.getOneById(f_id);
        JSONObject json = new JSONObject(product);
        responseJSON(response,json.toString());
    }


}

