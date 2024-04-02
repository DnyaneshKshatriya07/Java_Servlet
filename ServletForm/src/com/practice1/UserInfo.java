package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfo extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h2>Login Successful...</h2>");
		out.println("<h2>This is using SignIn</h2>");
		
		String name=req.getParameter("user_name");
//		String password=req.getParameter("password");
//		String email=req.getParameter("user_email");
//		String gender=req.getParameter("user_gender");
//		String course=req.getParameter("user_course");
		
		out.println("<h2>Welcome "+ name+"</h2>");
		out.println("<a href='info'><button>My Information</button></a>");
		
		//create a cookie
		Cookie un= new Cookie("user_name", name);
//		Cookie pw= new Cookie("password", password);
//		Cookie em= new Cookie("email", email);
//		Cookie gn= new Cookie("gender", gender);
//		Cookie cu= new Cookie("course", course);
		resp.addCookie(un);
//		resp.addCookie(pw);
//		resp.addCookie(em);
//		resp.addCookie(gn);
//		resp.addCookie(cu);
	}
}
