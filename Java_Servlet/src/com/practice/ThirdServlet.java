package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


//If we required protocol specific functionality in our web page then we have to extends HttpServlet.
public class ThirdServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("This is get Method...");
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.println("<h1>This is My get method Using HttpsServlet<h1/>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
