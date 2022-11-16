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
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


</head>
<body>
<div class="container singleName">
		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/book">Add Book</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h1>${name.title }</h1>
	<h3><strong>Des: </strong>${name.description }</h3>
	<p class="name">Added by: ${name.user.firstName }</p>
	<p class="gender">Gender: ${name.gender }</p>
	<p class="orgin">Origin: ${name.site }</p>
	

	<br>
	<br>
	<hr>
	
	<c:choose>
  		<c:when test="${name.user.id.equals(userName.id) }">
  			<a  href="/edit/book/${name.id}" class="btn btn-success">Edit Book</a><br><br>
  			<a href="/delete/book/${name.id }" class="btn btn-danger"> Delete Book</a>
			
  		</c:when>
  	</c:choose>
	
	</div>
</div>
</body>
</html>