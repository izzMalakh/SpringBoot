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
	
		</nav>
	<h5 style="font-size:4.4rem; margin-bottom:20px;">Edit Team</h5>
	<h3></h3>
	<div class="flex">
		<form:form method="post" action="/api/edit/team/${currentTeam.id}" modelAttribute="team">
		<div>
			<span>
				<form:label path="name"> Name</form:label>
			</span>
			<form:input path="name" type="text" class="giveteam" value="${currentTeam.name }" />
			<form:errors path="name" class="error"/>
		
		</div>
		<div>
			<span>
				<form:label path="level"> Level scale</form:label>
			</span>
			<form:input path="level" type="number" class="giveteam"  value="${currentTeam.level }" />
			<form:errors path="level" class="error"/>
			<p>${error }</p>
	
		</div>
	
		
		<div>
			<span>
				<form:label path="day">game day</form:label>
			</span>
			<form:input path="day" type="text"  value="${currentTeam.day }"  />
			<form:errors path="day" class="error"/>
		</div>

		

		
			<input type="hidden" name="user" value="${userName.id }"/>
			<form:input type="hidden" path="players"/>
			<input type="submit" value="Edit Team" class="submit"/>
		</form:form>
	</div>
		<a href="/delete/team/${currentTeam.id }" class="btn btn-danger"> Delete Team</a>
</div>
</body>
</html>