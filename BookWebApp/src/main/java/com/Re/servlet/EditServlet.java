package com.Re.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editurl")
public class EditServlet extends HttpServlet {

	

	private static final String query ="update  BookData set BookName=?, BOOKEDITION=?, BOOKPRICE=? where id=?";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	PrintWriter pw =res.getWriter();
	res.setContentType("text/html");
	
	// get the id of record
	  
	  int id= Integer.parseInt(req.getParameter("id"));
	  
	 //get the edit data we want
	  
	  String bookName= req.getParameter("BookName");
	  String bookprice=req.getParameter("bookEdition");
	  float bookEdition=Float.parseFloat(req.getParameter("bookEdition"));
	
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	catch(ClassNotFoundException cnf) {
		
		cnf.printStackTrace();
		}
	
	try(Connection con =DriverManager.getConnection("jdbc:mysql:///book","root","root");){
	
	 PreparedStatement ps =con.prepareStatement(query);	
	 	 
    ps.setString(1, bookName);
    ps.setString(2, bookprice);
    ps.setFloat(3, bookEdition);
	ps.setInt(4, id);
	
	int count=ps.executeUpdate();
	
	if(count ==1) {
		
		pw.println("<h2>Record is Edit Sucessfully</h2>");
	}
	else {
		
		pw.println("<h2>Record is not Edit Sucessfully</h2>");
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
	pw.println(" <a href='home.html'> Home</a>");
	pw.println("<br>");
	pw.println(" <a href='bookList'> Book List</a>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
	
	
	
	
}
