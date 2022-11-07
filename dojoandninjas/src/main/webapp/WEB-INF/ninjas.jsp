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
<title>Dojos and Ninjas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="container">
<nav>
	<a href="/">Home</a> |
	<a href="/add/ninja">Add Ninja</a> |
	<a href="/ninjas"> Ninjas</a> |
	<a href="/">Add Dojo</a>
</nav>
	<h1> All Ninjas</h1>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">dojo name</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
  <c:choose>
    		<c:when test="${ninjas.size() == 0 }">
    			<h3>No Ninjas :(</h3>
    		</c:when> 
  <c:otherwise>
  	<c:forEach var="ninja" items="${ninjas }">
    <tr>
      <th scope="row"></th>
      <td><a href="/edit/ninja/${ninja.id }"> ${ninja.firstName } ${ninja.lastName } </a></td>
      <td><a href="/dojo/${ninja.dojo.id }"> ${ninja.dojo.name } </a></td>
      <td><form action='/delete/ninja/<c:out value="${ninja.id}"/>' method="post" class="delete"><input type="hidden" name="_method" value="delete"><input type="submit" value="Delete"></form></td>
    </tr>
	</c:forEach>
	</c:otherwise>
		</c:choose>
  </tbody>
</table>


	
</div>

</body>
</html>