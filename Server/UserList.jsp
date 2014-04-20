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

<body>
	<form id="UserDetails" name="UserDetails" action="DetailsAction.jsp"
		method="get">

<select>

</select>
	</form>
</body>
</html>
