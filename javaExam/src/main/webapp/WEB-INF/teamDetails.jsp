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
			
		</nav>
	<h1>${name.name }</h1>
<a href="/dashboard">Dashboard</a> 
	<p class="name">Team Name: ${name.name }</p>
	<p class="gender">Skill level: ${name.level }</p>
	<p class="orgin">Game Day: ${name.day }</p>
	<br>
		<ul>
	<c:forEach var="user" items="${assignedUsers}">
		<li><c:out value="${user.userName}"></c:out></li>
	</c:forEach>
</ul>
number of players is :${name.players.size() }
	<br>
	<br>
	<hr>
		<p>add player</p>
		<form:errors path="players" class="error"/>

<hr>
<form:errors path="players" class="error"/>
<c:if test="${name.players.size() <9}">
<form action="/team/${id}" method="post">
		
	<select name="userId" id="userId" class="input">
	    <c:forEach var="user" items="${unassignedUsers}">
	    	<option value="${user.id}">${user.userName}</option>
	    </c:forEach>
	</select>
	
	<input class="input" class="button" type="submit" value="Add"/>
	
	
</form>
</c:if>
<c:if test="${name.players.size() >=9}">
	<p style="color:red;">team is full! you cant add more than 9</p>
	</c:if>
<c:choose>
  		<c:when test="${name.user.id.equals(userName.id) }">
  			<a  href="/edit/team/${name.id}" class="btn btn-success">Edit Team</a><br><br>
  			<a href="/delete/team/${name.id }" class="btn btn-danger"> Delete Team</a>
			
  		</c:when>
  	</c:choose>
  	

</div>
	
	
	</div>


</div>
</body>
</html>