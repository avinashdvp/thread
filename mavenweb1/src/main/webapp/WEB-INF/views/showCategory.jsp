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
 <h2>Category form</h2>
 <sptags:form class="form-horizontal" action="addCategory" method="post" commandName="cat">
   
   <div class="form-group">
     <label class="control-label col-sm-2" for="categoryName">categoryName</label>
     <div class="col-sm-10">
       <sptags:input path="categoryName" class="form-control" placeholder="categoryName"/>
     </div>
   </div>
   <div class="form-group">
     <label class="control-label col-sm-2" for="categoryDiscription">categoryDis</label>
        <div class="col-sm-10">
       <sptags:input path="categoryDiscription" class="form-control" placeholder="categoryDiscription"/>
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
        <th><h3>ID</h3></th>
        <th><h3>Name</h3></th>
        <th><h3>Price</h3></th>
         <th><h3>Edit</h3></th>
          <th><h3>Delete</h3></th>
        </tr>
    </thead>
    <jscore:forEach items="${categoryInfo}" var="c">
    <tbody>
      <tr>
        <td>${c.categoryId}</td>
        <td>${c.categoryName}</td>
        <td>${c.categoryDiscription}</td>
        <td><a href="#">edit</a>
        <td><a href="deleteCat?catId=${c.categoryId}">delete</a></td>
      </tr>  
     </jscore:forEach>   
      
      </tbody>
</table>
</body>
</html>