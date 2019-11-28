<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function myTrim(x) {
	  return x.replace(/^\s+|\s+$/gm,'');
	}
function validate()
{
          var r1=customerIdValidate();
          var r2=passwordValidate(); 
          var r3=nameValidate();
          var r4=emailIdValidate();
          var r5=mobileNoValidate();
          var result=r1&&r2&&r3&&r4&&r5;
          alert(result);
          return result;
}

function customerIdValidate()
{
    var regexp1=/(^[a-z A-Z])([0-9 A-Z a-z \. _]){7,20}$/;
    var customerId=document.getElementById("customerId").value;
    alert(customerId);
    var cv=myTrim(customerId);
    //if(myTrim(customerId).equals(""))
    //{
      //  alert("Customer Id Cannot be null");
        
    //}
    if(regexp1.test(customerId))
        {
       	 document.getElementById("cValidate").innerHTML="&#9989";
         document.getElementById("customerId").style.border="Solid Green";
         return true;
        
        }
        else
        {
        	document.getElementById("cValidate").innerHTML="&#10060";
            document.getElementById("customerId").style.border="Solid Red";
            return false;
        }
    
}
function passwordValidate()
{
    var regexp2=/(^[0-9 A-Z a-z ])([0-9 A-Z a-z \. _]){7,20}$/;
    var password=document.getElementById("password").value;
  //  if(myTrim(password)=="")
    //{
      //  alert("password Cannot be null");
    //}
    if(regexp2.test(password))
        {
        	 document.getElementById("pValidate").innerHTML="&#9989";
             document.getElementById("password").style.border="Solid Green";
             return true;
            
        }
        else
        {
        	document.getElementById("pValidate").innerHTML="&#10060";
            document.getElementById("password").style.border="Solid Red";
            return false;
        }
    
}
function nameValidate()
{
    var name=document.getElementById("name").value;
    var regexp3=/(^[a-z A-Z])([a-z A-z]){1,20}$/;
    if(myTrim(name)=="")
    {
        alert("Name Cannot be null");
    }
    else
    {
    
        if(regexp3.test(name))
        {
           
            document.getElementById("nValidate").innerHTML="&#9989";
            document.getElementById("name").style.border="Solid Green";
            return true;
            
        }
        else
        {
        	 document.getElementById("nValidate").innerHTML="&#10060";
             document.getElementById("name").style.border="Solid Red";
             return false;
        }
    }
}
function emailIdValidate()
{
    var regexp4=/(^[a-z A-Z])([0-9 A-Z a-z \._])+@([a-z A-z 0-9]){2,8}.([a-z A-z]){2,8}.([a-z A-z]){2,8}?$/;
    var emailId=document.getElementById("emailId").value;
    if(myTrim(emailId)=="")
    {
        alert("Email ID Cannot be null");
    }
    else
    {
    
        if(regexp4.test(emailId))
        {
        	 
        	 document.getElementById("eValidate").innerHTML="&#9989";
             document.getElementById("emailId").style.border="Solid Green";
             return true;
            
        }
        else
        {
        	document.getElementById("eValidate").innerHTML="&#10060";
            document.getElementById("emailId").style.border="Solid Red";
            return false;
        }
    }
}
function mobileNoValidate()
{
    var regexp5=/(^[0-9])([0-9]){9}$/;
    var mobileNo =document.getElementById("mobileNo").value;
   // if(myTrim(mobileNo)=="")
    //{
      //  alert("mobileNo Cannot be null");
    //}
    
    
    
        if(regexp5.test(mobileNo))
        {
        	document.getElementById("mValidate").innerHTML="&#9989";
            document.getElementById("mobileNo").style.border="Solid Green";
            return true;
        	
        }
        else
        {
        	document.getElementById("mValidate").innerHTML="&#10060";
            document.getElementById("mobileNo").style.border="Solid Red";
            return false;   
        }
    
}
</script>
<meta charset="ISO-8859-1">
<%
out.println("<script type='text/javascript'>");
RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JavaScriptFiles/CustomerRegistrationValidation.js");
out.println("</script>");
 %>
<title>Insert title here</title>
</head>
<body>
<form action="registerCustomer" onsubmit="return validate();">
<label>CustomerID:</label><br>
<input type="text" name="customerId" id="customerId"onblur="customerIdValidate()"/>
<label id="cValidate"></label><br>
<label>Password:</label><br>
<input type="password" name="password" id="password" onblur="passwordValidate()"/>
<label id="pValidate"></label><br>
<label>Name:</label><br>
<input type="text" name="name" id="name" onblur="nameValidate()"/>
<label id="nValidate"></label><br>
<label>Mobile No:</label><br>
<input type="text" name="mobileNo" id="mobileNo"onblur="mobileNoValidate()"/>
<label id="mValidate"></label><br>
<label>Email ID:</label><br>
<input type="email" name="emailId" id="emailId"onblur="emailIdValidate()"/>
<label id="eValidate"></label><br>
<input type="submit" value="Register">
</form>
</body>
</html>