<%@ page language="java" contentType="text/html; charset=ISO-8859-1"import="java.sql.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="new.css" />
</head>
<body background="images/sunflower.jpg">
 <% 
    String id= request.getParameter("userid");
 
    Class.forName("com.mysql.jdbc.Driver");
    Connection con =DriverManager.getConnection("Jdbc:mysql://localhost:3306/smartparent","root","jilsa");
    Statement stmt=con.createStatement();
    ResultSet rs= stmt.executeQuery("select * from registration where register_id='"+id+"'");
    if(rs.next())
    {
    	String name=rs.getString("name");
    	String phoneno=rs.getString("phone");
    	String approveflag=rs.getString("approval_flag"); 
    	String mail=rs.getString("email"); 
    	String loginid=rs.getString("login_id");
    	String addr=rs.getString("address"); 
    
    	%>
    	<form id="UserDetails" name="UserDetails" action="registerationaction.jsp"
		method="get">
		<div id="header">
  <div class="shell">
    <h1 id="logo"><a href="#"></a></h1>
    <div id="navigation">
      <ul>
        <li><a href="AdminHome.jsp">HOME</a></li>
        <li><a href="Approval.jsp">APPROVAL</a></li>
        <li><a href="UsersList.jsp" class="active">USER DETAILS</a></li>
        <li><a href="AdminChangePassword.jsp">CHANGE PASSWORD</a></li>
        <li><a href="Logout.jsp">LOG OUT</a></li>
       
      </ul>
    </div>
    
  </div>
</div>
	<div class="wrapper_content5">		
		
						<div class="myBox">
						<div class="myfirst" style="height:100px"></div>
				<div class="myFirst">

					<div class="mysecond">
						Name
					</div>
					<div class="mythird">
						<div class="myLabel">
							<input type="text" id="txtName" name="txtName" value="<%=name%>"/>
						</div>
					</div>
				</div>
				
				<div class="myFirst">

					<div class="mysecond">
						Phone number
					</div>

					<div class="mythird">
						<div class="myLabel">
							<label> <input type="text" name="txtPhone"
								id="txtPhone" value="<%=phoneno%>"/>
							</label>
						</div>
					</div>

				</div>
				
				<div class="myFirst">

					<div class="mysecond" >
						Approval Flag
					</div>
					<div class="mythird">
						<div class="myLabel">
							<input type="text" id="txtapproveflag" name="txtapproveflag" value="<%=approveflag%>" />
						</div>
					</div>
				</div>
				
				<div class="myFirst">

					<div class="mysecond">
						Email
					</div>

					<div class="mythird">
						<div class="myLabel">
							<label> <input type="text" name="txtemail"
								id="txtemail" value="<%=mail%>"/>
							</label>
						</div>
					</div>

				</div>
				
				
				
				
				<div class="myFirst">

					<div class="mysecond">
						Address
					</div>

					<div class="mythird">
						<div class="myLabel">
							<input type="text" name="txtaddress" id="txtaddress" value="<%=addr%>"/>
						</div>
					</div>

				</div>
				

				<div class="myFirst">

					<div class="mysecond">
						Login id
					</div>

					<div class="mythird">
						<div class="myLabel">
							<label> <input type="text" name="txtLoginid" id="txtLoginid"value="<%=loginid%>" />
							</label>
						</div>
					</div>

				</div>
				
				
			</div>

		</div>
	</form>

   </div>
 <%} %> 
    
   
</body>
</html>