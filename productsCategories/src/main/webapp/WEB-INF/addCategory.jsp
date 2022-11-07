<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<style>
.container{
width:1000px;
border: 1px solid gray;
margin-top:10px;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1 style="margin-top:10px;">New Cataegory</h1>
<a href="/"> Home </a>
<hr>
<form:form method="post" action="/api/add/category" modelAttribute="category">
<table class="table">
  <thead>
    <tr>

      <th scope="col"><form:label path="name">Category Name:</form:label>
      <form:errors path="name" class="error" style="color:red;"/>
     
      </th>
      <th> <form:input path="name" type="text" style="width:500px; "/> </th>
     
    </tr>

  </thead>
    <tbody>
    
    <tr>
    
    </tr>
    

  </tbody>

</table>

 <input type="submit" value="Add Category"  class="btn btn-primary" class="submit" style="margin-bottom:30px; margin-left:30px;" />
  
</div>
 
</form:form>
</body>
</html>