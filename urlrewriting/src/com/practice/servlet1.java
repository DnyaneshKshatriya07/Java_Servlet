package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>Welcome to Servlet1</h1>");
		
		String name=req.getParameter("user_name");
		out.println("<h1>Welcome "+name+"</h1>");
		
		
		//This is using URLRewriting...
		out.println("<a href='servlet2?user="+name+"'> Go to second_servlet</a>");
		
		//This is Using Hidden Form...
		out.println("<form action='servlet2'>"
				+"<input type='hidden' name='user_name' value='"+name+"'/>"
				+"<button>Goto second page</button>"
				+"</form>");
	}

}
