<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
 <% 
String username=request.getParameter("usernameET");
String password=request.getParameter("passwordET");
Class.forName("com.mysql.jdbc.Driver");
Connection con =DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent","root","jilsa");
Statement stmt=con.createStatement();
//ResultSet rs=stmt.executeQuery("select * from adminlogin");
ResultSet rs=stmt.executeQuery("select * from admin_login where username='"+username+"' and password='"+password+"'");

if(rs.next())
{
	session.setAttribute("adminlogin_id",""+rs.getInt("admin_id"));
	response.sendRedirect("AdminHome.jsp?user='"+username+"'"); 
}
else
{
	response.sendRedirect("index.jsp?s=fail");
}

%>