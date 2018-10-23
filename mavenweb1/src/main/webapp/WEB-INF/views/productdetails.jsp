<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="homehedder.jsp" %>
<html>
<head>
<style>
body  
{
    background-image: url("F:\\mavenweb1\\src\\main\\webapp\\resources\\bgb.jpg");
    background-color: #cccccc;
}
body {
  margin: 0;
}

/* Style the header */
.header {
    background-color: #f1f1f1;
    padding: 20px;
    text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  
</head>
<body>
<div  class = "container" >
 <div class="card" style="width:700px" >
 <img class="card-img-top" src="resources/${productInfo.productId}.jpg" alt="Card image" style="width:100%" style="color:black">
    <div class="card-body">
      <h4 class="card-title"><h3>${productInfo.name}</h3>
      <p class="card-text" color="yellow"><h3><b>${productInfo.description}</b></h3></p>
      <h4><p class="card-text">${productInfo.price} only!</p></h4>
      <form action="cart" method="get">
<input type="hidden" name="id" value="${productInfo.productId}">
<div class="container">
	<div class="row">
		<div class="col-lg-2">
           <div class="input-group">
    <span class="input-group-btn">
      <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
   <span class="glyphicon glyphicon-minus"></span>
   </button>
   </span>
 <input type="number" id="quantity" name="quantity" class="form-control input-number" value="1" maxlength="10">
 <span class="input-group-btn">
 <button type="button" class="quantity-right-plus btn btn-success btn-number" datatype="plus" data-field="">
 <span class="glyphicon glyphicon-plus"></span>
 </button>
 </span>
 </div>
 </div>
</div>
</div>
<h3><input type="submit" name="button" value="add to cart"> 
</h3></form> 
</div>
</div>
</div>
 </body>
</html>
