package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;
import javax.xml.ws.Response;

public class FirstServlet implements Servlet{

	
	ServletConfig conf;
	//Life Cycle Method
	@Override
	public void init(ServletConfig conf) throws ServletException {
		this.conf=conf;
		System.out.println("Creating object......");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("Servicing.........");
		
		//set the content type of response
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>This is My OutPut Using Servlet<h1/>");
		out.println("<h1>+Todays Date and Time is "+ new Date().toString() +" <h1/>");
		
		out.println("<h4><a href=\"index.html\">index</h4>");
	}
	
	@Override
	public void destroy() {
		System.out.println("Getting to Destroy.....");
		
	}
	
	//Non Life Cycle Method
	@Override
	public ServletConfig getServletConfig() {
		return this.conf;
	}

	@Override
	public String getServletInfo() {
		return "This Servlet is created by Dnyanesh Kshatriya ";
	}

}
