<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
  <%
	try {
		
		String registerid = request.getParameter("registerid");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent", "root", "jilsa");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from registration  where register_id='"+registerid+"'");
		out.println("Rejected");
		response.sendRedirect("Approval.jsp");
		}
catch (Exception e)
	{
	
	}
%>