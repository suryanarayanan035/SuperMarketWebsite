function validate()
{
          var r1=customerIdValidate();
          var r2=passwordValidate(); 
          var r3=nameValidate();
          var r4=emailIdValidate();
          var r5=mobileNoValidate();
          var result=r1&&r2&&r3&&r4&&r5;
          return result;
}

function customerIdValidate()
{
    var regexp1=/(^[a-z A-Z])([0-9 A-Z a-z \. _]){7,20}$/;
    var customerId=document.getElementsByName("customerId");
    if(customerId.value.trim()=="")
    {
        alert("Customer Id Cannot be null");
        
    }
    else
    {
    
        if(regexp1.test(customerId))
        {
            document.getElementById("ciValidate").innerHTML="&#9989";
            document.getElementById("customerId").style.borderColor="Solid Red";
            return false;
        }
        else
        {
            document.getElementById("ciValidate").innerHTML="&#10060";
            document.getElementById("customerId").style.borderColor="Solid Green";
            return true;
        }
    }
}
function passwordValidate()
{
    var regexp2=/(^[0-9 A-Z a-z ])([0-9 A-Z a-z \. _]){7,20}$/;
    var password=document.getElementsByName("password");
    if(password.value.trim()=="")
    {
        alert("password Cannot be null");
    }
    else
    {
    
        if(regexp2.test(password))
        {
            document.getElementById("pValidate").innerHTML="&#9989";
            document.getElementById("password").style.borderColor="Solid Red";
            return false;
        }
        else
        {
            document.getElementById("pValidate").innerHTML="&#10060";
            document.getElementById("password").style.borderColor="Solid Green";
            return true;
        }
    }
}
function nameValidate()
{
    var name=document.getElementsByName("name");
    var regexp3=/(^[a-z A-Z]){7,20}$/;
    if(name.value.trim()=="")
    {
        alert("Name Cannot be null");
    }
    else
    {
    
        if(regexp3.test(name))
        {
            document.getElementById("nValidate").innerHTML="&#9989";
            document.getElementById("name").style.borderColor="Solid Red";
            return false;
        }
        else
        {
            document.getElementById("nValidate").innerHTML="&#10060";
            document.getElementById("name").style.borderColor="Solid Green";
            return true;
        }
    }
}
function emailIdValidate()
{
    var regexp4=/(^[a-z A-Z])([0-9 A-Z a-z \._])+@([a-z A-z 0-9]){2,8}.([a-z A-z]){2,8}.([a-z A-z]){2,8}?$/;
    var emailId=document.getElementsByName("emailId");
    if(emailId.value.trim()=="")
    {
        alert("Email ID Cannot be null");
    }
    else
    {
    
        if(regexp4.test(emailId))
        {
            document.getElementById("eValidate").innerHTML="&#9989";
            document.getElementById("emailId").style.borderColor="Solid Red";
            return false;
        }
        else
        {
            document.getElementById("eValidate").innerHTML="&#10060";
            document.getElementById("emailId").style.borderColor="Solid Green";
            return true;
        }
    }
}
function mobileNoValidate()
{
    var regexp5=/(^[0-9])([0-9]){9}$/;
    var mobileNo =document.getElementsByName("mobileNo");
    if(mobileNo.value.trim()=="")
    {
        alert("mobileNo Cannot be null");
    }
    else
    {
    
        if(regexp5.test(mobileNo))
        {
            document.getElementById("mValidate").innerHTML="&#9989";
            document.getElementById("mobileNo").style.borderColor="Solid Red";
            return false;
        }
        else
        {
            document.getElementById("mValidate").innerHTML="&#10060";
            document.getElementById("mobileNo").style.borderColor="Solid Green";
            return true;
        }
    }
}