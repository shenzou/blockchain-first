package com.shenzou.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Resource(name="jdbc/studentdb")
	private DataSource dataSource;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		//Step2: Get a connection to the database
		Connection myConn=null;
		Statement myStmt= null;
		ResultSet myRs=null;
		try
		{
			myConn= dataSource.getConnection();
		//Step3: create SQL statements
		String sql = "select * from student";
		myStmt = myConn.createStatement();
		//Step4: Execute SQL query
		myRs=myStmt.executeQuery(sql);
		//Step5: Process the ResultSet
		
		while(myRs.next())
			{
				String email = myRs.getString("email");
				out.println(email);
			
			}
		}
		catch(Exception exc)
		{
			System.out.println(exc.getMessage());
		}
		
	}
	

}
