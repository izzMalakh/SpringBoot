<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
body{
padding:50px;
}
</style>
</head>
<body>
<nav>
	<a href="/">Home</a> |
	<a href="/add/ninja">Add Ninja</a> |
	<a href="/ninjas"> Ninjas</a> |
	<a href="/">Add Dojo</a>
</nav>
<h1> New Dojo </h1>
<form:form action="/dojos" method="post" modelAttribute="dojo">
 
 			<div>
 					<form:label path="name">Name</form:label>
 					<form:errors path="name" class="error"/>
 			
 				<form:input type="text" path="name"  />
 			</div>
 	
 	<br>
 			<input type="submit" value="Submit" /> 
 		</form:form>
 		
</body>
</html>