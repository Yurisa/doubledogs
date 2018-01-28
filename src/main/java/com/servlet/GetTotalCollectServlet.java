package com.servlet;

import com.entity.Person;
import com.service.PersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yurisa on 2017/6/28.
 */
@WebServlet("/gettotalcollectnum")
public class GetTotalCollectServlet extends AutowiredHttpServlet {
    @Autowired
    private PersonService personService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Person person = (Person) session.getAttribute("person");
        int p_id = person.getP_id();
        int collectnum = personService.getTotalCollectNum(p_id);
        JSONObject json = new JSONObject();
        json.put("collectnum", collectnum);
        responseJSON(response, json.toString());

    }
}
