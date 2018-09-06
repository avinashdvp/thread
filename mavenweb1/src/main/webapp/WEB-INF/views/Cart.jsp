<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jscore" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CART</title>

 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
<style>
.bootstrap-iso .form-control:focus{border-color: #5cb85c;  box-shadow: none; -webkit-box-shadow: none;}
.bootstrap-iso .has-error .form-control:focus{box-shadow: none; -webkit-box-shadow: none;}
</style>
</head>
<body>
<table class="table table-dark table-hover" bgcolor="white">
    <thead>
      <tr>
      <th><h3>cartUser</h3></th>
        <th><h3>ID</h3></th>
        <th><h3>Name</h3></th>
        <th><h3>Price</h3></th>
        <th><h3>total</h3></th>
          <th><h3>quantity</h3></th>
          
        </tr>
    </thead>
    <jscore:forEach items="${cartInfo}" var="c">
    <tbody>
      <tr>
      <td><br><br>${c.cartUser}</td>
        <td><br><br>${c.categoryId}</td>
        <td><br><br>${c.productName}</td>
        <td><br><br>${c.productPrice}</td>
         <td><br><br>${c.totalPrice}
        <td><br><br>${c.quantity}</td>
       
      </tr>   
     </jscore:forEach>   
     
      </tbody>
</table>
</body>
</html>