<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String registerid=request.getParameter("id");%>
<div id="myHome">
						<div class="Box">
				<div class="myFirst">

					<div class="mysecond">
						<div class="myLabel">REGISTER ID</div>
					</div>
					<div class="mysecond">
						<div class="myLabel">
							<input type="text" id="txtUserName" name="txtUserName" value=<%=registerid%> />
						</div>
					</div>
				</div>
				<br /> <br />
</div>
</div>
</body>
</html>