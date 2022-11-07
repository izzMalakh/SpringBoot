<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
body {
	max-width: 1080px;
	margin: auto;
}
h1 {
	text-align: center;
}
</style>

<title>View Product</title>
</head>
<body>

<h1>${product.name}</h1>
<p><a href="/">Home</a></p>
<hr>

<h3>Categories:</h3>
<ul>
	<c:forEach var="category" items="${assignedCategories}">
		<li><c:out value="${category.name}"></c:out></li>
	</c:forEach>
</ul>
<hr>
<form action="/products/${id}" method="post">
	<h4>Add Category:</h4>				
	<select name="categoryId" id="categoryId" class="input">
	    <c:forEach var="category" items="${unassignedCategories}">
	    	<option value="${category.id}">${category.name}</option>
	    </c:forEach>
	</select>
	<input class="input" class="button" type="submit" value="Add"/>
</form>
<div class="delete">
<form action='/product/delete/<c:out value="${product.id}"/>' method="post" class="delete">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete Product" class="btn btn-danger">
				</form>  
</div>
</body>
</html>