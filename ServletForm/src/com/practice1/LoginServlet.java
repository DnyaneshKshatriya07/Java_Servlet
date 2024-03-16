package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Welcome to Servlet</h1>");

        String name = req.getParameter("user_name");
        String password = req.getParameter("password");

        boolean isValid = validateLogin(name, password);

        if (isValid) {
            RequestDispatcher rd = req.getRequestDispatcher("UserInfo");
            rd.forward(req, resp);
        } else {
            out.println("<h2>Invalid Username or Password</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("signin.html");
            rd.include(req, resp);
        }
    }

    private boolean validateLogin(String name, String password) {
        boolean isValid = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?useSSL=false", "root", "root");
            ps = con.prepareStatement("SELECT * FROM registration WHERE Name=? AND Password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            isValid = rs.next(); // If any row found, set isValid to true
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isValid;
    }
}
