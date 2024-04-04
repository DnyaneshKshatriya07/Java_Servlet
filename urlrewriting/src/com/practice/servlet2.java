package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>Welcome to Servlet2</h1>");
		
		//This is Using URLRewring...
		String name=req.getParameter("user");
		out.println("<h1>Welcome back "+ name+"</h1>");
		
		//This is Using Hidden Form...
		String name1=req.getParameter("user_name");
		out.println("<h1>Welcome back "+ name1+"</h1>");
	}
}
