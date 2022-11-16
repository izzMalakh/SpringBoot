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
			<a href="/add/thing">Add Thing</a> |
			<a href="/logout">Logout</a>
		</nav>
	<h5 style="font-size:4.4rem; margin-bottom:20px;">Add Thing</h5>
	<h3></h3>
	<div class="flex">
		<form:form method="post" action="/api/add/thing" modelAttribute="thing">
		<div>
			<span>
				<form:label path="name"> Name</form:label>
			</span>
			<form:input path="name" type="text" class="givething"/>
			<form:errors path="name" class="error"/>
			<p>${error }</p>
		</div>
		
		<div>
			<span>
				<form:label path="gender">Gender</form:label>
			</span>
			<form:select path="gender">
				<form:option value="witcher">Witcher</form:option>
				<form:option value="wizard">Wizard</form:option>
				<form:option value="elf">Elf</form:option>
				<form:option value="dwarf">Dwarf</form:option>
			
			</form:select>
			<form:errors path="gender" class="error"/>
		</div>
		
		<div>
			<span>
				<form:label path="origin">Orgin</form:label>
			</span>
			<form:input path="origin" type="text" />
			<form:errors path="origin" class="error"/>
		</div>
		
		<div>
			<span>
				<form:label path="description">description:</form:label>
			</span>
			<form:input path="description" type="text" />
			<form:errors path="description" class="error"/>
		</div>
		
			<input type="hidden" name="user" value="${userName.id }"/>
			
			<input type="submit" value="Add Thing" class="submit"/>
		</form:form>
	</div>
</div>
</body>
</html>