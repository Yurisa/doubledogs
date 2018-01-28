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
@WebServlet("/judgelogin")
public class JudgeLoginServlet extends AutowiredHttpServlet {
    @Autowired
    private PersonService personService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject json = new JSONObject();
        HttpSession session = request.getSession(true);
        Person person = null;
        person = (Person)session.getAttribute("person");
        if (person == null){
            json.put("success",0);
        }else {
            json.put("success",1);
            json.put("person",new JSONObject(person));
        }
        responseJSON(response,json.toString());
    }
}
