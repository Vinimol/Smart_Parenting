<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.sql.*"
    pageEncoding="ISO-8859-1"%>
        	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="new.css" />
</head>
<body>
<form action="" name="approve" id="approve">
<div id="header">
  <div class="shell">
    <h1 id="logo"><a href="#"></a></h1>
    <div id="navigation">
      <ul>
        <li><a href="AdminHome.jsp">HOME</a></li>
        <li><a href="Approval.jsp">APPROVAL</a></li>
        <li><a href="UsersList.jsp">USER DETAILS</a></li>
        <li><a href="AdminChangePassword.jsp" class="active">CHANGE PASSWORD</a></li>
        <li><a href="Logout.jsp">LOG OUT</a></li>
       
      </ul>
    </div>
    
  </div>
</div>
<div class="wrapper_content5">
<div class="myleft" style="margin-top: 50px; color:#C60">
<div class="myHeading">
<div class="mycolumn">id</div></div>
<div class="mycolumn"><div class="myHeading">Name</div></div>
<div class="mycolumn"><div class="myHeading">phone</div></div>
<div class="mycolumn"><div class="myHeading">approval</div></div>
<div class="mycolumn"><div class="myHeading">email</div></div>
<div class="mycolumn"><div class="myHeading">address</div></div>
</div>
<% 
try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con =DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent","root","jilsa");
    Statement stmt=con.createStatement();
    ResultSet rs= stmt.executeQuery("select* from registration  where approval_flag='"+1+"'");
  while(rs.next())
    {
	   String id=rs.getString("register_id");
    	String name=rs.getString("name");
    	String phoneno=rs.getString("phone");
    	String approvalflag=rs.getString("approval_flag"); 
    	String mail=rs.getString("email"); 
    	String loginid=rs.getString("login_id");
    	String address=rs.getString("address");
	%>
<br>
<div class="myleft">
<div class="mycolumn"><%=id%></div>
<div class="mycolumn"><%=name%></div>
<div class="mycolumn"><%=phoneno%></div>
<div class="mycolumn"><%=approvalflag%></div>
<div class="mycolumn"><%=mail%></div>
<div class="mycolumn"><%=address%></div>
</div>
<br>
<%
}
}
catch(Exception e)
{
	
}
    	%>
    
    	</div>
    
    	</form>
    	<div class="footer_link">smart parenting
 </div>
</body>
</html>