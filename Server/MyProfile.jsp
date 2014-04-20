<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form id="MyProfile" name="MyProfile">
<%
String myusername = request.getParameter("user");
%>
<div id="myHome">
<div class="myTab">
<label><a  href="AdminHome.html">HOME</a></label>
</div>
<div class="myTab">
<label><a href="myprofile.jsp">MY PROFILE</a></label>
</div>
<div class="myTab">
<label><a href="UsersList.jsp"> USER  DETAILS</a></label>
</div>
<div class="myTab">
<label><a href="AdminChangePassword.html"> CHANGE PASSWORD</a></label>
</div>
<div class="myTab">
<label><a href="AdminHome.html">LOGOUT</a></label>
</div>
<div class="Box">
<div class="myFirst">

<div class="mysecond">
<div class="myLabel">Address</div>
</div>

<div class="mysecond">
<div class="myLabel">

<label> <input type="text" name="txtPhoneNo" id="txtPhoneNo" value=<%=myusername%> />
							</label></div>
</div>

</div>
<br>
<div class="myFirst">

<div class="mysecond">
<div class="myLabel">First Name</div>
</div>

<div class="mysecond">
<div class="myLabel">Neethu</div>
</div>

</div>
<br />
<div class="myFirst">

<div class="mysecond">
<div class="myLabel">Last Name
</div>
</div>

<div class="mysecond">
<div class="myLabel">Premadas </div>
</div>

</div>
<br />
<div class="myFirst">

<div class="mysecond">
<div class="myLabel">Gender</div>
</div>

<div class="mysecond">
<div class="myLabel">Female</div>
</div>

</div>
<br />
<div class="myFirst">
  <div class="mysecond"><div class="myLabel">mail</div></div>
<div class="mysecond">
<div class="myLabel">n@gmail.com </div>
</div>

</div>
<br />

<div class="myFirst">

<div class="mysecond">
<div class="myLabel">Phone Number</div>
</div>

<div class="mysecond">
<div class="myLabel">9645145330</div>
</div>

</div>
<br />
<div class="myFirst">

<div class="mysecond">
<div class="myLabel">Address</div>
</div>

<div class="mysecond">
<div class="myLabel">

<label> <input type="text" name="txtPhoneNo" id="txtPhoneNo" value=<%=myusername%> />
							</label></div>
</div>

</div>
<br />
<div class="myFirst">

<div class="mysecond">
<div class="myLabel"><input name="submit" type="submit" value="SUBMIT" /></div>
</div>

<div class="mysecond">
<div class="myLabel"></div>
</div>

</div>
</div>
</div>
</form>
</body>
</html>