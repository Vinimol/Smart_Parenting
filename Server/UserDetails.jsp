<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	function fun() {

		var firstname = document.getElementById("txtFirstName").value;
		var lastname = document.getElementById("txtLastName").value;
		var gender = document.getElementById("radioGender").value;
		var email = document.getElementById("txtEmail").value;
		var phno = document.getElementById("txtPhoneNo").value;
		var address = document.getElementById("txtareaAddress").value;
		if (firstname == "") {
			alert("plz enter first name.....")
			return false;
		}
		else if (lastname == "") {
			alert("plz enter last name.....")
			return false;
		}
		else if (gender == "") {
			alert("plz enter gender.....")
			return false;
		}
		else if (email== "") {
			alert("plz enter email.....")
			return false;
		}
		else if (phno == "") {
			alert("plz enter phno.....")
			return false;
		}
		else if (address == "") {
			alert("plz enter address.....")
			return false;
		}
		else {
			alert("hai.." + firstname);
			return true;
		}

	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>

<body background="images/sunflower.jpg">
	<form id="UserDetails" name="UserDetails" action="DetailsAction.jsp"
		method="get">
		<div id="myHome">
			<div id="title"></div>
			<div class="myTab">
				<label><a href="index.html">HOME</a></label>
			</div>
			<div class="myTab">
				<label><a href="UserRequest1.html">USER REQUEST</a></label>
			</div>
			<div class="myTab">
				<label><a href="UsersList.jsp"> USER DETAILS</a></label>
			</div>
			<div class="myTab">
				<label><a href="AdminChangePassword.html"> CHANGE
						PASSWORD</a></label>
			</div>
			<div class="myTab">
				<label><a href="index.html">LOGOUT</a></label>
			</div>
			<div class="Box">
				<div class="myFirst" style="margin-top: 20px">

					<div class="mysecond">
						<div class="myLabel">Name</div>
					</div>
					<div class="mysecond">
						<div class="myLabel">
							<input type="text" id="txtFirstName" name="txtFirstName" />
						</div>
					</div>
				</div>
				

				
				<div class="myFirst">

					<div class="mysecond">
						<div class="myLabel">Gender</div>
					</div>

					<div class="mysecond">
						<div class="myLabel">
							<label> <input name="radioGender" type="radio" id="radioGender"
								value="Male" /> Male
							</label> <label> <input name="radioGender" type="radio" id="radioGender"
								value="Female" /> Female
							</label>

						</div>
					</div>

				</div>
				
				<div class="myFirst">

					<div class="mysecond">
						<div class="myLabel">Email</div>
					</div>

					<div class="mysecond">
						<div class="myLabel">
							<input type="text" name="txtEmail" id="txtEmail" />
						</div>
					</div>

				</div>
				

				<div class="myFirst">

					<div class="mysecond">
						<div class="myLabel">Phone Number</div>
					</div>

					<div class="mysecond">
						<div class="myLabel">
							<label> <input type="text" name="txtPhoneNo" id="txtPhoneNo" />
							</label>
						</div>
					</div>

				</div>
				
				<div class="myFirst">

					<div class="mysecond">
						<div class="myLabel">Address</div>
					</div>

					<div class="mysecond">
						<div class="myLabel">
							<label>txtareaAddress <textarea name="txtareaAddress" id="txtareaAddress"></textarea>
							</label>
						</div>
					</div>

				</div>
				
				<div class="myFirst">

					<div class="mysecond">
						<div class="myLabel">
							<input name="submit" id="submit" type="submit" value="SUBMIT"
								onclick="return fun();" />
						</div>
					</div>

					<div class="mysecond">
						<div class="myLabel"></div>
					</div>

				</div>
			</div>

		</div>
	</form>
	<div class="footer_link">smart parenting
 </div>
</body>
</html>
