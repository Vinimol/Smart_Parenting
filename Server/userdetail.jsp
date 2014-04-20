<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hii...
<%
String firstname=request.getParameter("txtFirstName");
String lastname=request.getParameter("txtLaststName");
String gender=request.getParameter("radioGender");
String email=request.getParameter("txtEmail");
String phno=request.getParameter("txtPhoneNo");
out.print(firstname);
out.print(lastname);
out.print(gender);
out.print(email);
out.print(phno);
%>

</body>
</html>