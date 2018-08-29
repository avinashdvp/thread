<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sptags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jscore" %>
<html>
<head>
 <title>Bootstrap Example</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
.bootstrap-iso .form-control:focus{border-color: #5cb85c;  box-shadow: none; -webkit-box-shadow: none;}
.bootstrap-iso .has-error .form-control:focus{box-shadow: none; -webkit-box-shadow: none;}
 </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="registeration" >REGISTER</a>
    </li>
    
<li class="nav-item">
      <a class="nav-link" href="login" >LOGIN</a>
    </li>
    </ul>
  </nav>
<div class="container">
  <h2>products</h2>
  
 <table class="table table-dark table-hover" bgcolor="black">
    <thead>
      <tr>
        <th><h3>ID</h3></th>
        <th><h3>Name</h3></th>
        <th><h3>Price</h3></th>
        <th><h3>image</h3></th>
        
          
        </tr>
    </thead>
    <jscore:forEach items="${productInfo}" var="p">
    <tbody>
      <tr>
        <td>${p.productId}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td><a href="cartPro?proId=${p.productId}"><img src="resources/${p.productId}.jpg" size="120" width="100" ></a>
      </tr>   
     </jscore:forEach>   
     
      </tbody>
</table>
</body>
</html>