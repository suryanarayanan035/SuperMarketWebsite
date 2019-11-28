<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Market Login</title>
<script type="text/javascript">
function myTrim(x) {
	  return x.replace(/^\s+|\s+$/gm,'');
	}
function validate()
{
	var customerId=document.getElementById("marketId").value;
	var password=document.getElementById("password").value;
	if(myTrim(customerId)==""||myTrim(password)=="")
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
<form action="marketLogin" onsubmit="return validate();">
<label>MarketID:</label><br>
<input type="text" name="marketId" id="marketId" required/><br>
<label>Password:</label><br>
<input type="password" name="password" id="password" required/><br>
<input type="submit" value="Login">
</form>
<label id="msg" style="color:red;"></label>
</body>
</html>