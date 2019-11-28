<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="LoginForm.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<script type="text/javascript">
function myTrim(x) {
	  return x.replace(/^\s+|\s+$/gm,'');
	}
function validate()
{
	var adminId=document.getElementById("adminId").value;
	var password=document.getElementById("password").value;
	if(myTrim(adminId)==""||myTrim(password)=="")
		{
			document.getElementById("msg").innerHTML="Username Or Password cannot be null<br>spaces and tabs are not allowed";
			
			return false;
		}
	else
		{
			return true;
		}
	}
</script>
</head>
<body>
<div class="container">
<form action="AdminLogin" onsubmit="return validate();">
<label>Admin ID:</label><br>
<input type="text" name="adminID" id="adminId" required/><br>
<label>Password</label><br>
<input type="password" name="password" id="password"required/><br>
<input type="submit">
</form>
<label id="msg" style="color:red"></label>
</div>
</body>
</html>