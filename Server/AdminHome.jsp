 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.jcarousel.js"></script>
<script type="text/javascript" src="js/fancybox/jquery.fancybox-1.3.1.js"></script>
<script type="text/javascript" src="js/jquery-func.js"></script>	

<script type="text/javascript">
	$(document).ready(function() {
		$('#submit').click(function() {
			var firstname = $('#txtFirstName').val();
			var lastname = $('#txtLastName').val();
			var gender = $('#radioGender').val();
			var email = $('#txtEmail').val();
			var phno = $('#txtPhoneNo').val();
			var address = $('#txtareaAddress').val();
			if (firstname == "") {
				alert("Invalid First Name..");
			} else if (lastname == "") {
				alert("Invalid Last Name..");
			} else if (gender == "") {
				alert("Invalid Gender..");
			} else if (email == "") {
				alert("Invalid Last Name..");
			}

		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="new.css" />
</head>

<body  background="images/sunflower.jpg">
	<form id="AdminHome" name="AdminHome">
	<%
	String myusername = request.getParameter("user");
	%>
		
<div id="header">
  <div class="shell">
    <h1 id="logo"><a href="#"></a></h1>
    <div id="navigation">
      <ul>
        <li><a href="AdminHome.jsp" class="active">HOME</a></li>
        <li><a href="Approval.jsp">APPROVAL</a></li>
        <li><a href="UsersList.jsp">USER DETAILS</a></li>
        <li><a href="AdminChangePassword.jsp">CHANGE PASSWORD</a></li>
        <li><a href="Logout.jsp">LOG OUT</a></li>
       
      </ul>
    </div>
    
  </div>
</div>
<div id="slider">
  <div class="shell">
    <ul>
      <li>
        <div class="image"> <img src="css/images/slide-112.jpg" alt="" /> </div>
        <div class="data">
          <h2 class="slider-h">Smart Parenting.</h2>
          <p style="color:#F00;">&quot;The all-in-one worry-free parenting App.&quot;</p>
          </div>
      </li>
      <!-- <li>
        <div class="image"> <img src="css/images/slide-111.jpg" alt="" /> </div>
        <div class="data">
          <h2 class="slider-h">Tracking.....</h2>
          <p style="color:#F00;">&quot;Mobile monitoring applications provide the benefit of storing all the Android phone information into your authorized account&quot;</p>
          </div>
      </li>
      <li>
        <div class="image"> <img src="css/images/slide-113.jpg" alt="" /> </div>
        <div class="data">
          <h2 class="slider-h">Exact location of your Child</h2>
          <p style="color:#F00;">&quot;Alerts you when they are in trouble.&quot;</p>
           </div>
      </li> -->
    </ul>
  </div>
</div>

	</form>
	<div class=" home_content">
	
		<!-- Track your child's location. The GPS finder on the family monitor feature allows you to locate your kid's current and previous locations. Set up location alerts for school, safe places and restricted places. The "drop-off" feature alerts you if your child leaves a designated area.</h2>
<h2>
Using GPS technology, the Child Tracker app gives you the exact location of your family members and alerts you when they are in trouble, using the app's innovative check in feature.
		</h2> -->

	
	</div>
	<div class="footer_link">smart parenting
 </div>
</body>
</html>