<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
    <%
	try {
		
		String registerid = request.getParameter("registerid");
		//?name=&phone=&email=&address=&username=&password=
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent", "root", "jilsa");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("update registration set approval_flag=1 where register_id='"+registerid+"'");
		out.println("Accepted");
		response.sendRedirect("Approval.jsp");
				}
catch (Exception e)
	{
		
	
	}
%>