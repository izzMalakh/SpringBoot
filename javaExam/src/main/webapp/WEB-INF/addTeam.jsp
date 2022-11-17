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
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
		<nav>
			<a href="/dashboard">Dashboard</a> |
		
			<a href="/logout">Logout</a>
		</nav>
	<h5 style="font-size:4.4rem; margin-bottom:20px;">Add Team</h5>
	<h3></h3>
	<div class="flex">
		<form:form method="post" action="/api/add/team" modelAttribute="team">
		<div>
			<span>
				<form:label path="name"> Name</form:label>
			</span>
			<form:input path="name" type="text" class="giveteam"/>
			<form:errors path="name" class="error"/>
			<p>${error }</p>
		</div>
		
		
				<div>
			<span>
				<form:label path="level">skill level (1-5)</form:label>
			</span>
			<form:input path="level" type="number" class="giveteam"/>
			<form:errors path="level" class="error"/>
			<p>${error }</p>
		</div>
		<div>
			<span>
				<form:label path="day">Game Day</form:label>
			</span>
			<form:input path="day" type="text" />
			<form:errors path="day" class="error"/>
		</div>
		
	
		
			<input type="hidden" name="user" value="${userName.id }"/>
			
			<input type="submit" value="Add Team" class="submit"/>
		</form:form>
		
	</div>
</div>
</body>
</html>