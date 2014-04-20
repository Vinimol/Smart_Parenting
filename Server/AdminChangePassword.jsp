<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="new.css" />
</head>
<body >
<form name="ChangePassword" id="ChangePassword" action="AdminChangePasswordAction.jsp">
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
<div class="picture"></div>
			<div class="box">
				<div class="myfirst" style="height: 100px"></div>		
				<div class="myFirst">
					<div class="mysecond">
						Old Password:
					</div>
					<div class="mythird">
					<input type="password" name=txtoldpassword id=txtoldpassword /></div>
				</div>
						
				<div class="myFirst">
					<div class="mysecond">
						New Password:
					</div>
					<div class="mythird">
					<input type="password" name=txtnewpassword id=txtnewpassword/>
					</div>
				</div>
				
						
		
				<div class="myFirst">
						<div class="mysecond">
						Renter New Password
						</div>
						<div class="mythird">
						<input type="password" name=txtconfirmnewpassword id=txtconfirmnewpassword/>
						</div>
				</div>
	
				<div class="myFirst" style="width:600px;">
						<div class="mysecond" style="margin-left: 50px">
				
						</div>
						<div class="mythird">
						
						<input name="submit" id="submit" type="submit" value="SUBMIT">
						</div>
				</div>
			</div>
			
			
			</div>
			
			
		</form>
		<div class="footer_link">smart parenting
 </div>
</body>
</html>