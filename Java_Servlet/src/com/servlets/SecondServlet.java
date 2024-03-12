package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("This is using Generic Servlet");
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h4>This is using Generic Servlet</h4>");
		
		out.println("<h4><a href=\"index.html\">index</h4>");
	}

}
