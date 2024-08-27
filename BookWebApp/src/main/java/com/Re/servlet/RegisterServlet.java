package com.Re.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XPrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final String query ="INSERT INTO  BookData(BookName, BOOKEDITION, BOOKPRICE) ValUES(?,?,?)";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("Registration Servlet called");
		RequestDispatcher rd = req.getRequestDispatcher("/");
		rd.forward(req, res);
	
	}
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		
		String BookName=req.getParameter("bookName");
		String bookEdition=req.getParameter("bookEdition");
		float bookprice = Float.parseFloat(req.getParameter("bookPrice"));
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException cnf) {
			
			cnf.printStackTrace();
			}
		
		try(Connection con =DriverManager.getConnection("jdbc:mysql:///book","root","root");){
		
		 PreparedStatement ps =con.prepareStatement(query);	
		 
		 ps.setNString(1,   BookName);
		 ps.setString(2, bookEdition);
	    ps.setFloat(3, bookprice);	
		int count= ps.executeUpdate();
	    if(count==1) {
	    	
	    	pw.println("<h2>Record Is Registered Sucessfully</h2>");
	    }
	    
	    else {
	    	
	    	pw.println("<h2>Record Is not Registered Sucessfully</h2>");
	    }
		}
		catch(SQLException se) {
			
			se.printStackTrace();
		    pw.println("<h1>"+se.getMessage()+"</h2>"); 	
		}
		catch(Exception e) {
		
			e.printStackTrace();
			 pw.println("<h1>"+e.getMessage()+"</h2>"); 
		}
		
		pw.println(" <a href='home.html'> Home List</a>");
		pw.println("<br>");
		pw.println(" <a href='bookList'> Book List</a>");
	}
	
	
}
