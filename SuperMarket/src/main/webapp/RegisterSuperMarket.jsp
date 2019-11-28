<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    response.setHeader("cache-control","no-cache, no-store, must-revalidate");
		String user=(String)session.getAttribute("adminId");
    	out.println(user);
    	if(user.equals(""))
    	{
    		response.sendRedirect("AdminLogin.jsp");
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register SuperMarket</title>
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
          var r6=cityValidate();
          var r7=streetLine1Validate();
          var r6=localityValidate();
          var result=r1&&r2&&r3&&r4&&r5&&r6&&r7&&r8;
          alert(result);
          return result;
}

function marketIdValidate()
{
    var regexp1=/(^[a-z A-Z])([0-9 A-Z a-z \. _]){7,20}$/;
    var customerId=document.getElementById("marketId").value;
    alert(customerId);
    var cv=myTrim(customerId);
    //if(myTrim(customerId).equals(""))
    //{
      //  alert("Customer Id Cannot be null");
        
    //}
    if(regexp1.test(customerId))
        {
       	 document.getElementById("midValidate").innerHTML="&#9989";
         document.getElementById("marketId").style.border="Solid Green";
         return true;
        
        }
        else
        {
        	document.getElementById("midValidate").innerHTML="&#10060";
            document.getElementById("marketId").style.border="Solid Red";
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
function streetLine1Validate()
{
    var regexp5=/(^[a-z A-Z]([a-z A-Z]){2,20}$)/;;
    var streetLine1 =document.getElementById("streetLine1").value;
   // if(myTrim(mobileNo)=="")
    //{
      //  alert("mobileNo Cannot be null");
    //}
    
    
    
        if(regexp5.test(streetLine1))
        {
        	document.getElementById("sl1Validate").innerHTML="&#9989";
            document.getElementById("streetLine1").style.border="Solid Green";
            return true;
        	
        }
        else
        {
        	document.getElementById("sl1Validate").innerHTML="&#10060";
            document.getElementById("streetLine1").style.border="Solid Red";
            return false;   
        }
    
}
function localityValidate()
{
    var regexp5=/(^[a-z A-Z]([a-z A-Z]){2,20}$)/;
    var locality =document.getElementById("locality").value;
   // if(myTrim(mobileNo)=="")
    //{
      //  alert("mobileNo Cannot be null");
    //}
    
    
    
        if(regexp5.test(locality))
        {
        	document.getElementById("localityValidate").innerHTML="&#9989";
            document.getElementById("locality").style.border="Solid Green";
            return true;
        	
        }
        else
        {
        	document.getElementById("localityValidate").innerHTML="&#10060";
            document.getElementById("locality").style.border="Solid Red";
            return false;   
        }
    
}
function cityValidate()
{
    var regexp5=/(^[a-z A-Z]([a-z A-Z]){2,20}$)/;
    var city =document.getElementById("city").value;
   // if(myTrim(mobileNo)=="")
    //{
      //  alert("mobileNo Cannot be null");
    //}
    
    
    
        if(regexp5.test(city))
        {
        	document.getElementById("cityValidate").innerHTML="&#9989";
            document.getElementById("city").style.border="Solid Green";
            return true;
        	
        }
        else
        {
        	document.getElementById("cityValidate").innerHTML="&#10060";
            document.getElementById("city").style.border="Solid Red";
            return false;   
        }
    
}
</script>

</head>
<body>
<form action="RegisterMarket" onsubmit="return validate();">
<label>MarketID:</label><br>
<input type="text" name="marketId" id="marketId"onblur="marketIdValidate()" required/>
<label id="midValidate" ></label><br>
<label>Password:</label><br>
<input type="password" name="password" id="password" onblur="passwordValidate()" required/>
<label id="pValidate" ></label><br><br>
<label>Name:</label><br>
<input type="text" name="name" id="name"onblur="nameValidate()" required/>
<label id="nValidate" ></label><br><br>
<label>MobileNo:</label><br>
<input type="text" name="mobileNo" id="mobileNo"onblur="mobileNoValidate()" required/>
<label id="mValidate" ></label><br><br>
<label>StreetLine1:</label><br>
<input type="text" name="streetLine1" id="streetLine1" onblur="streetLine1Validate()" required/>
<label id="sl1Validate" ></label><br><br>
<label>Locality:</label><br>
<input type="text" name="locality" id="locality"onblur="localityValidate()" required/>
<label id="localityValidate" ></label><br><br>
<label>City:</label><br>
<input type="text" name="city" id="city"onblur="cityValidate()" required/>
<label id="cityValidate" ></label><br><br>
<label>EmailID:</label><br>
<input type="text" name="emailId" id="emailId" onblur="emailIdValidate()" required/>
<label id="evalidate" ></label><br><br>
<input type="submit" value="Register Shop" >
</form>
<%
String msg=(String)session.getAttribute("msg");
System.out.print(msg);
if(!msg.equals(""))
{
	
}
%>
</body>
</html>