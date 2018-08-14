
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sptags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jscore" %>
<html lang="en">
<head>
 <title>Bootstrap Example</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

<div class="container">
 <h2>Product form</h2>
 <sptags:form class="form-horizontal" action="addProduct" method="post" commandName="pro">
   <div class="form-group">
     <label class="control-label col-sm-2" for="productId">productId</label>
     <div class="col-sm-10">
       <sptags:input path="productId" class="form-control" placeholder="productId"/>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="name">Product Name</label>
     <div class="col-sm-10">
       <sptags:input path="name" class="form-control" placeholder="name"/>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="price">Product price</label>
     <div class="col-sm-10">
       <sptags:input path="price" class="form-control" placeholder="price"/>
     </div>
   </div>
   
   <div class="form-group">
     <div class="col-sm-offset-2 col-sm-10">
       <div class="checkbox">
         <label><input type="checkbox" name="remember"> Remember me</label>
       </div>
     </div>
   </div>
   <div class="form-group">
     <div class="col-sm-offset-2 col-sm-10">
       <button type="submit" class="btn btn-default">Submit</button>
     </div>
   </div>
 </sptags:form>
</div>
<div class="container">
  <h2>products</h2>
  
 <table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        </tr>
    </thead>
    <jscore:forEach items="${productInfo}" var="p">
    <tbody>
      <tr>
        <td>${p.productId}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
     </jscore:forEach>   
      </tr>
      </tbody>
</table>
</body>
</html>



