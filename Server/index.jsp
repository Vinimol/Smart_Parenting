<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="jquery-1.8.3.min.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("helo..");

		$('#Login').click(function() {
			var username = $('#usernameET').val();
			var password = $('#passwordET').val();
			
			if (username == "") {
				alert("Invalid username..");
				return false;
			} else if (password == "") {
				alert("Invalid password..");
				return false;
			} 
			else
				{
				return true;
				}

		});
	});
	<%try
	{
	String status = request.getParameter("r");
			if (status.equals("success")) {%>
	alert("Succesfullly Registered");
	<%} else {%>
		alert("Registeration failed");

	<%}
	}
	catch(Exception e)
	{
		
	}
	try
	{
	String loginstatus = request.getParameter("s");
			if (loginstatus.equals("success")) {%>
	alert("Succesfullly logged");
	<%} else {%>
		alert("Invalid USER name & password");

	<%}
			
			
			
	}
	catch(Exception e)
	{
		
	}
	
	String sss=""+session.getAttribute("adminloginid");
	if(!sss.equals(""))
	{
		
		response.sendRedirect("AdminHome.jsp");
		
	}
	%>
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="new.css" />
</head>

<body background="images/header.jpg" >
	<form id="AdminLogin" name="AdminLogin" action="AdminLogAction.jsp" method="post">

		<div id="header">
  <div class="shell">
    <h1 id="logo"><a href="#"></a></h1>
    
    
  </div>
</div>
			<div class="Box" style="margin-top: 50px;">

				<div class="myFirst">
					<div class="mysecond">
						User Name
					</div>
					<div class="mythird">
						<label> 
						<input type="text" name="usernameET"
								id="usernameET" />
							</label>
					</div>
					

				</div>

				<div class="myFirst">

					<div class="mysecond">
						Password
					</div>

					<div class="mythird">
						
							<label> <input type="password" name="passwordET"
								id="passwordET" />
							</label>

						
					</div>

				</div>

				<br>

					<div class="myFirst">
						<div class="mysecond">
							<div class="myLabel" style="margin-left: 120px;">
								<input name="Login" id="Login" value="Login" type="submit" style="height: 30px;width: 60px"/>
							</div>
						</div>

						<div class="mysecond">
							<div class="myLabel">
								<input name="Cancel" id="Cancel" value="Cancel" type="reset" style="height: 30px;width: 60px"/>
							</div>
						</div>

					</div> 
			</div>

	</form>
</body>
</html>
