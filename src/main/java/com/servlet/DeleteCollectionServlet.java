package com.servlet;

import com.entity.Person;
import com.service.PersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yurisa on 2017/7/1.
 */
@WebServlet("/deletecollection")
public class DeleteCollectionServlet extends AutowiredHttpServlet {
    @Autowired
    private PersonService personService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = null;
        JSONObject json = new JSONObject();
        int f_id = Integer.parseInt(request.getParameter("f_id"));
        HttpSession session = request.getSession(true);
        person = (Person) session.getAttribute("person");
        if(person == null){
          json.put("success",0);
        }else {
        int p_id = person.getP_id();
        personService.deleteCollection(f_id,p_id);
        json.put("success",1);
        }
        responseJSON(response,json.toString());
    }
}
