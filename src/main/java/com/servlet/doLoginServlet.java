package com.servlet;

import com.entity.Person;
import com.service.PersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Yurisa on 2017/5/24.
 */
//@Component
@WebServlet("/dologin")
public class doLoginServlet extends AutowiredHttpServlet {
	@Autowired
	private PersonService personService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      JSONObject json = new JSONObject();
      if(personService.checkUser(email,password)){
          Person person = personService.getPerson(email);
          HttpSession session = request.getSession(true);
          session.setAttribute("person",person);
          json.put("success",1);
          json.put("person",new JSONObject(person));
      }else {
          json.put("success",0);
      }
     responseJSON(response,json.toString());
    }
}
