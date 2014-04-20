<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
   
    <%
	try {
		String myloginid=(String)session.getAttribute("adminlogin_id").toString();
			String myuser=request.getParameter("txtusername");
		out.print(""+myloginid);
		String oldpassword= request.getParameter("txtoldpassword");
	
		String newpassword= request.getParameter("txtnewpassword");
		String confirmnewpassword= request.getParameter("txtconfirmnewpassword");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent", "root", "jilsa");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("update admin_login set password='"+newpassword+"'where admin_id="+myloginid+"");
		response.sendRedirect("AdminHome.jsp");
			}
catch (Exception e)
	{
	response.sendRedirect("index.jsp?s=fail");
	
	}
%>
   
