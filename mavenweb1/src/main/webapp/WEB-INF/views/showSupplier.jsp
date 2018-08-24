<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sptags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jscore" %>
<%@include file="adminhedder.jsp" %>
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
 <h2>Supplier form</h2>
 <sptags:form class="form-horizontal" action="addSupplier" method="post" commandName="supply">
   
   <div class="form-group">
     <label class="control-label col-sm-2" for="suppliername">supplierName</label>
     <div class="col-sm-10">
       <sptags:input path="suppliername" class="form-control" placeholder="suppliername"/>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="supplierDescription">supplierDes</label>
        <div class="col-sm-10">
       <sptags:input path="supplierDescription" class="form-control" placeholder="supplierDescription"/>
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
 <table class="table table-dark table-hover">
    <thead>
      <tr>
        <th><h3>ID</h3></th>
        <th><h3>Name</h3></th>
        <th><h3>Description</h3></th>
        <th><h3>Edit</h3></th>
          <th><h3>Delete</h3></th>
        </tr>
    </thead>
    <jscore:forEach items="${supplierInfo}" var="s">
    <tbody>
      <tr>
        <td>${s.supplierId}</td>
        <td>${s.suppliername}</td>
        <td>${s.supplierDescription}</td>
         <td><a href="#">edit</a>
        <td><a href="deleteSupply?supplyId=${s.supplierId}">delete</td>
        
     </jscore:forEach>   
      </tr>
      </tbody>
</table>
</body>
</html>