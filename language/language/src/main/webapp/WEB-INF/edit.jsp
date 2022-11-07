
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
/* form */
form{padding:0 50px;}
form div{display:flex; align-items:center; justify-content:start; flex-wrap:wrap; padding-bottom:25px;}
form div span{width: 150px; display: block;}
form div input{width: 300px; padding:10px;}
.error{color:var(--red);}
</style>
</head>
<body>
<form:form action="/api/update/${language.id}" method="post" modelAttribute="language">
	<div>
		<span>
		<form:label path="name">Name:</form:label>
		<form:errors path="name" class="error"/>
		</span>
		
			<form:input type="text" path="name"/>
			
	</div>
	
	<div>
		<span>
		<form:label path="creator">Creator:</form:label>
		<form:errors path="creator" class="error"/>
		</span>
			<form:input type="text" path="creator"/>
	</div>
	
	<div>
		<span>
		<form:label path="version">version:</form:label>
		<form:errors path="version" class="error"/>
		</span>
			<form:input type="number" path="version" step=".01"/>
	</div>
	
	
	<input type="submit" value="submit" class="btn btn-success"/>
	</form:form>
	</div>
			
</body>
</html>