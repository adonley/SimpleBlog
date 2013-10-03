package com.KeepinItSimpleApps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private String user = "admin";
	private String password = "password";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated constructor stub
        String id = request.getParameter("name");
        String pass = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        request.setAttribute(id, "name");
        if(id.equals(user) && pass.equals(password)){
            rd = request.getRequestDispatcher("/WelcomeServlet");
            rd.forward(request, response);
        }
        else{
            out.println("<b>Invalid Login Info.</b><br>");
            rd = request.getRequestDispatcher("/login.vm");
            rd.include(request, response);
        }
        out.close();
 
    }

}
