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
<title>dashboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
<div class="container dash">

		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/team">Add Team</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h1>Welcome  <span>${logged.userName }!</span></h1>

	<div class="flex">
	<h2><span>Team Names:</span> </h2>
	<c:choose>
  		<c:when test="${teams.size() == 0 }">
  			<p>We have no teams at the moment, add one!</p>
  		</c:when>

  		<c:otherwise>
  		<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Level</th>
      <th scope="col">Number of players</th>
      <th scope="col"> Game day</th>
	
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var="nm" items="${teams }">
    <tr>
      <th scope="row"></th>
      <td><a href="/team/${nm.id }">${nm.name }</a></td>
      <td>${nm.level }</td>
      <td>${nm.players.size() }/9</td>
      <td>${nm.day }</td>
 
      
      
    </tr>
  </c:forEach>
  </tbody>
</table>
			
			
			
  		</c:otherwise>
	</c:choose>
	<a href="/add/team" class="btn btn-success">Add Team</a> 
	</div>
</div>
</body>
</html>