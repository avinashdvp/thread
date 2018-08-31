<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
.bootstrap-iso .form-control:focus{border-color: #5cb85c;  box-shadow: none; -webkit-box-shadow: none;}
.bootstrap-iso .has-error .form-control:focus{box-shadow: none; -webkit-box-shadow: none;}
 
input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border-color: none;
    background-color: none;
    color: black;
}

 </style>
</head>
<body>

<form class="form-horizontal" action="checklogin" method="post" >
   
   <div class="form-group">
     <label class="control-label col-sm-2" for="username">username</label>
     <div class="col-sm-10">

<input type="text" name="username" class="form-control" placeholder="please enter username"/>
</div>
   </div>
 <div class="form-group">
     <label class="control-label col-sm-2" for="password">password</label>
     <div class="col-sm-10">

<input type="password" name="password" class="form-control" placeholder="please enter password"/>
<input type="submit" name="submit" value="login">
</div>
   </div>
</form>
</body>
</html>