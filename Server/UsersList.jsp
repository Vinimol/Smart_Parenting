<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="new.css" />
</head>
<body background="images/sunflower.jpg">
<form id="form1" name="form1" method="post" action="DisplayUserDetails.jsp">
<div id="header">
  <div class="shell">
    <h1 id="logo"><a href="#"></a></h1>
    <div id="navigation">
      <ul>
        <li><a href="AdminHome.jsp" >HOME</a></li>
        <li><a href="Approval.jsp">APPROVAL</a></li>
        <li><a href="UsersList.jsp" class="active">USER DETAILS</a></li>
        <li><a href="AdminChangePassword.jsp">CHANGE PASSWORD</a></li>
        <li><a href="Logout.jsp">LOG OUT</a></li>
       
      </ul>
    </div>
    
  </div>
</div>
<div class="wrapper_content5">	
			<div class="select" style="margin-top: 50px;float: left;margin-left: 400px"> 
			<select name="userid" id="userid" >
<%
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent", "root","jilsa");
Statement stmt = con.createStatement();
ResultSet rs=stmt.executeQuery("select * from registration where approval_flag='1'");
while(rs.next())
{
String name=rs.getString("name");
String id=rs.getString("register_id");
%>
    <option value="<%=id%>"><%=name%></option>     
 <% 
  }
  }
catch (Exception e)
{
}
%>
</select>
<input type="submit" name="Details" value="Details"/>
   <a href="UserDetailsDisplay.jsp">All Users Details</a>
</div>

  
  </div>
 
 
</form>
<div class="footer_link">smart parenting</div>
</body>
</html>