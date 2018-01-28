package com.servlet;

import com.entity.Person;
import com.service.PersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yurisa on 2017/6/29.
 */
@WebServlet("/isrepeat")
public class IsRepeatEmailServlet extends AutowiredHttpServlet {
    @Autowired
    private PersonService personService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email").toString();
        JSONObject json = new JSONObject();
        List<Person> personlist = personService.getPersonList();
        for (Person item : personlist ){
             if (item.getEmail().equals(email)){
                 json.put("isrepeat",1);
             }else {
                 json.put("isrepeat",0);
             }
        }
        responseJSON(response,json.toString());
    }
}
