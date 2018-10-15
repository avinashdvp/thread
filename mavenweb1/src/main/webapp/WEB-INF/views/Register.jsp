<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="homehedder.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sptags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Bootstrap Example</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
<style>
.bootstrap-iso .form-control:focus{border-color: #5cb85c;  box-shadow: none; -webkit-box-shadow: none;}
.bootstrap-iso .has-error .form-control:focus{box-shadow: none; -webkit-box-shadow: none;}

input[type=text] {
    width: 50%;
    padding: 10px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border-color:black ;
    background-color: none;
    color: black;
}

</style>
</head>
<body>

<div class="container">
<sptags:form class="form-horizontal"   name="addregister" action="addregister" method="post" commandName="reg"  onsubmit="confirm()">
   
   <div class="form-group">
     <label class="control-label col-sm-2" for="username">userName</label>
     <div class="col-sm-10">
       <sptags:input path="username" class="form-control" placeholder="name"/>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="dob">date of birth</label>
     <div class="col-sm-10">
       <sptags:input path="dob" class="form-control" placeholder="dob"/>
     </div>
   </div>
    
   <div class="form-group">
     <label class="control-label col-sm-2" for="address">Address</label>
     <div class="col-sm-10">
       <sptags:input path="address" class="form-control" placeholder="address"/>
     </div>
   </div>
     <div class="form-group">
     <label class="control-label col-sm-2" for="password">password</label>
     <div class="col-sm-10">
       <sptags:input path="password" class="form-control" placeholder="password"/>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="email">email</label>
     <div class="col-sm-10">
       <sptags:input path="email" class="form-control" placeholder="email"/>
     </div>
   </div>
   <div class="form-group">
     <div class="col-sm-offset-2 col-sm-10">
       <button type="submit" class="btn btn-default">Submit</button>
     </div>
   </div>
 </sptags:form>
   </div>
   <script>
   function confirm()
 {
   var Password=document.addregister.password.value;
   
  if(Password.length>6)
        {
        return true;
        }
    else
        {
        alert("password is too short");
        return false;
        }
}
   </script>
</body>
</html>