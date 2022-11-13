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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
body{
padding-left:100px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h1> Add a book to your Shelf!</h1>
<a href="/dashboard"> back to the shelves</a>

	<form:form method="post" action="/api/add/book" modelAttribute="book">
			<div>
			
				<span>
					<form:label path="title">Title</form:label>
					
				</span>
				
				<form:input path="title" type="text" />
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
			<form:input type="hidden" value="${logged}" path="user"/>	
			<input type="submit" value="Add Book" class="submit"/>
		</form:form>
</div>

</body>
</html>