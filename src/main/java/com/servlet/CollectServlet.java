package com.servlet;

import com.entity.Person;
import com.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yurisa on 2017/6/8.
 */
@WebServlet("/collect")
public class CollectServlet extends AutowiredHttpServlet {
    @Autowired
    private ProductService productservice;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        JSONObject json = new JSONObject();
        Person person = new Person();
        person = (Person) session.getAttribute("person");
        if (person == null) {
            json.put("success", 0);
        } else {
            int p_id = person.getP_id();
            int f_id = Integer.parseInt(request.getParameter("f_id"));
            System.out.print("收到" + f_id);
            productservice.insertFp(f_id, p_id);
           json.put("success",1);
        }
        responseJSON(response, json.toString());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);

    }


}
