package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class info extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h2>This is using Session traking</h2>");
		
		Cookie [] cookies=req.getCookies();
		boolean f=false;
		String name="";
//		String password="";
//		String email="";
//		String gender="";
//		String course="";
		
		if(cookies==null){
			out.println("<h2>You are new user</h2>");
		}
		else{
			for(Cookie c: cookies){
				String tname=c.getName();
//				String tpassword=c.getName();
//				String temail=c.getName();
//				String tgender=c.getName();
//				String tcourse=c.getName();
				if(tname.equals("user_name")){
					
					f=true;
					name=c.getValue();
//					password=c.getValue();
//					email=c.getValue();
//					gender=c.getValue();
//					course=c.getValue();
				}
			}
		}
		
		if(f){
			out.println("<h2>Welcome "+ name+"</h2>");
			out.println("<br>");
			out.println("<h2>Your Details as follow:- </h2>");
			out.println("<h2>Name:- "+ name+"</h2>");
//			out.println("<h2>Welcome "+ password+"</h2>");
//			out.println("<h2>Welcome "+ email+"</h2>");
//			out.println("<h2>Welcome "+ gender+"</h2>");
//			out.println("<h2>Welcome "+ course+"</h2>");
		}
		else{
			out.println("<h2>You are new user</h2>");
		}
		
	}
}
