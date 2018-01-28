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
@WebServlet("/selecttypebypricehigh")
public class SelecttypeByPricehighServlet extends AutowiredHttpServlet {
    @Autowired
    ProductService productservice;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int curr = Integer.parseInt(request.getParameter("page"));
        String type = request.getParameter("type").toString();
        int pagesize = 4;
        int currnum = (curr-1)*pagesize;
        int productnum = productservice.getTotalNumByType(type);
        List<Product> productlist  = productservice.getProductlistByTypePricehigh(type,currnum);
        int totalnum = (productnum+pagesize-1)/pagesize;
        JSONArray json = new JSONArray();
        for(Product pro : productlist){
            JSONObject product = new JSONObject(pro);
            json.put(product);
        }
        JSONObject jproduct = new JSONObject();
        jproduct.put("productJsonList",json);
        jproduct.put("totalnum",totalnum);
        responseJSON(response,jproduct.toString());


    }


}
