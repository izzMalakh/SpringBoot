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
			<a href="/add/thing">Add Thing</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h1>Welcome  <span>${logged.firstName }!</span></h1>
	<h3>test test test test </h3>
	<div class="flex">
	<h2><span>Thing Names:</span> </h2>
	<c:choose>
  		<c:when test="${things.size() == 0 }">
  			<p>We have no things at the moment, add one!</p>
  		</c:when>

  		<c:otherwise>
  		<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Gender</th>
      <th scope="col">Origin</th>
	<th scope="col">Posted By</th>
	<th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="nm" items="${things }">
    <tr>
      <th scope="row"></th>
      <td><a href="/thing/${nm.id }">${nm.name }</a></td>
      <td>${nm.gender }</td>
      <td>${nm.origin }</td>
      <td>${nm.user.firstName }</td>
      
      <c:if test = "${ nm.user.id == logged.id }">
      <td> <a href="/delete/thing/${nm.id}"> Delete </a>  | <a href="/edit/thing/${nm.id}"> Edit </a> </td>
      </c:if>
      
      <c:if test = "${ nm.user.id != logged.id }">
      <td> </td>
      </c:if>
      
    </tr>
  </c:forEach>
  </tbody>
</table>
			
			
			
  		</c:otherwise>
	</c:choose>
	
	</div>
</div>
</body>
</html>