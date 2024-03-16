package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.*;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;


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

		        try
		        {				        	
		        	Class.forName("com.mysql.jdbc.Driver"); 
							
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
					PreparedStatement ps=((java.sql.Connection) con).prepareStatement("INSERT INTO registration VALUES(?,?,?,?,?)");
		        		
		            ps.setString(1, name);
		            ps.setString(2, password);
		            ps.setString(3, email);
		            ps.setString(4, gender);
		            ps.setString(5, course);
		            int count = ps.executeUpdate();
		            if (count == 1) {
		            	RequestDispatcher rd=req.getRequestDispatcher("success");
						rd.forward(req, resp);
		            } else {
		                out.println("<h2>Record not Registered Sucessfully");
		            }
		        } catch (SQLException se) {
		            se.printStackTrace();
		            out.println("<h1>" + se.getMessage() + "</h2>");
		        } catch (Exception e) {
		            e.printStackTrace();
		            out.println("<h1>" + e.getMessage() + "</h2>");
		        }				
			}
			else{
				out.println("<h2>You have not accept terms and condtion..</h2>");
			}
		}
		else{
			out.println("<h2>You have not accept terms and condtion..</h2>");
			
			RequestDispatcher rd=req.getRequestDispatcher("signup.html");
			
			rd.include(req, resp);
		}
	}
}
