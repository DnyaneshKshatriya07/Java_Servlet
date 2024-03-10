package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>Welcome to Registration Servlet</h1>");
		
		String name=req.getParameter("user_name");
		String password=req.getParameter("password");
		String email=req.getParameter("user_email");
		String gender=req.getParameter("user_gender");
		String course=req.getParameter("user_course");
		
		String cond=req.getParameter("condition");
		if(cond!=null){
			if (cond.equals("checked")) {
				out.println("<h2>Name:- "+ name +"</h2>");
				out.println("<h2>Password:- "+ password +"</h2>");
				out.println("<h2>email:- "+ email +"</h2>");
				out.println("<h2>gender:- "+ gender +"</h2>");
				out.println("<h2>course:- "+ course +"</h2>");
			}
			else{
				out.println("<h2>You have not accept terms and condtion..</h2>");
			}
		}
		else{
			out.println("<h2>You have not accept terms and condtion..</h2>");
		}
	}
}
