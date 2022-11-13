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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
body{
padding:100px;
}
</style>
</head>
<body>
	<h1> Change Your Entry </h1>
	<a href="/dashboard"> back to shelv</a>
	<form:form method="post" action="/api/edit/book/${book.id}" modelAttribute="book">
<input type="hidden" name="_method" value="put">
			<div>
			
				<span>
					<form:label path="title">Title</form:label>
					
				</span>
				
				<form:input path="title" type="text"  />
			</div>
			<form:errors path="title"/>
			
			<div>
				<span>
					<form:label path="author">Author</form:label>
				</span>
				<form:input path="author" type="text" />
			</div>
				<form:errors path="author"/>
			<div>
				<span>
					<form:label path="thoughts">Description</form:label>
					
				</span>
				<form:input path="thoughts" type="text" />
			</div>
			<form:errors path="thoughts"/>
			<br>
			
				<form:input type="hidden" path="borrower" />
			<input type="submit" value="edit Book" class="submit"/>
			
		</form:form>
	
</body>
</html>