package com.servlet;

import com.entity.Person;
import com.entity.Product;
import com.service.PersonService;
import com.service.ProductService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yurisa on 2017/6/12.
 */
@WebServlet("/getpersoncollection")
public class GetPersonCollectionServlet extends AutowiredHttpServlet {
    @Autowired
    ProductService productservice;
    @Autowired
    PersonService personservice;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        JSONObject jproduct = new JSONObject();
        JSONArray json = new JSONArray();
        Person person = null;
        person = (Person)session.getAttribute("person");
        if(person == null){
            jproduct.put("productJsonList",0);
        }else {
            int curr = Integer.parseInt(request.getParameter("page"));
            int p_id = person.getP_id();
            int pagesize = 4;
            int currnum = (curr-1)*pagesize;
            int productnum = personservice.getTotalCollectNum(p_id);
            List<Product> productlist = productservice.getPersonCollection(p_id,currnum);
            int totalnum = (productnum+pagesize-1)/pagesize;
            jproduct.put("totalnum",totalnum);
            System.out.print(totalnum);
            for (Product pro : productlist) {
                JSONObject product = new JSONObject(pro);
                json.put(product);
            }
        }
        jproduct.put("productJsonList",json);
        responseJSON(response,jproduct.toString());


    }

}
