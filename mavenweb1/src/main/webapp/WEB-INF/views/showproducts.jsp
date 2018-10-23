
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sptags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jscore" %>
<%@include file="homehedder.jsp" %>
<html lang="en">
<head>
 <title>Bootstrap Example</title>
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

<div class="container">
 <h2>Product form</h2>
 <sptags:form class="form-horizontal" action="addProduct" method="post" commandName="pro" enctype="multipart/form-data">
   
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
     <label class="control-label col-sm-2" for="price">Product Description</label>
     <div class="col-sm-10">
       <sptags:input path="description" class="form-control" placeholder="description"/>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="categoryName">categoryName</label>
     <div class="col-sm-10">
       <sptags:select path="categoryName"  class="form-control">
        <jscore:forEach items="${catinfo}" var="c">
  <option value="${c.categoryName}">${c.categoryName}</option>
  </jscore:forEach>
  
</sptags:select>

     </div>
     
   </div>
   
   <div class="form-group">
     <label class="control-label col-sm-2" for="supplierName">supplierName</label>
     <div class="col-sm-10">
       <sptags:select path="supplierName" class="form-control" placeholder="supplierName">
       <jscore:forEach items="${supinfo}" var="s">
        <option value="${s.suppliername}">${s.suppliername}</option>
        </jscore:forEach>
        </sptags:select>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="stock">stock</label>
     <div class="col-sm-10">
       <sptags:input path="stock" class="form-control" placeholder="stock"/>
     </div>
   </div>
    <div class="form-group">
     <sptags:input type="file" path="productimg" class="form-control" placeholder="productimg"/>
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
       </sptags:form>
     </div>
     
   </div>


<div class="container">
  <h2>products</h2>
  
 <table class="table table-dark table-hover" bgcolor="black">
    <thead>
      <tr>
        <th><h3>ID</h3></th>
        <th><h3>Name</h3></th>
        <th><h3>Price</h3></th>
        <th><h3>Edit</h3></th>
          <th><h3>Delete</h3></th>
          <th><h3>images</h3></th>
          <th><h3>categoryName</h3></th>
          <th><h3>supplierName</h3></th>
        </tr>
    </thead>
    <jscore:forEach items="${productInfo}" var="p">
    <tbody>
      <tr>
        <td><br><br>${p.productId}</td>
        <td><br><br>${p.name}</td>
        <td><br><br>${p.price}</td>
         <td><br><br><a href="editPro?proId=${p.productId}">edit</a>
        <td><br><br><a href="deletePro?proId=${p.productId}"> delete</a></td>
        <td><img src="resources/${p.productId}.jpg"></td>
        <td><br><br>${p.categoryName}</td>
        <td><br><br>${p.supplierName}</td>
      </tr>   
     </jscore:forEach>   
     
     
      </tbody>
</table>
</body>
</html>



