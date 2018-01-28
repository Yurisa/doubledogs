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
 * Created by Yurisa on 2017/6/29.
 */
@WebServlet("/addperson")
public class AddPersonServlet extends AutowiredHttpServlet {
    @Autowired
    private PersonService personService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Person person = new Person();
        person.setEmail(email);
        person.setPassword(password);
        personService.addPerson(person);
        JSONObject json = new JSONObject();
        json.put("success",1);
        responseJSON(response,json.toString());
    }
}
