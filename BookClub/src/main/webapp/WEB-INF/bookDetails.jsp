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
padding:100px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="font-family:monospace;"> ${book.title }</h1>
	

  		<c:choose>
  		  			<c:when test="${user_id == book.user.id}">
  		<h2> you read ${book.title } by ${book.author }.  </h2>
<h3> Here are ${book.user.firstName }'s thoughts </h3>
<hr>
 <p>${book.thoughts }</p>
 					</c:when>  
 <c:otherwise>
<h2> ${book.user.firstName } read ${book.title } by ${book.author }.  </h2>
<h3> Here are ${book.user.firstName }'s thoughts </h3>
<hr>
 <p>${book.thoughts }</p>
 </c:otherwise>
 							</c:choose>
 
 <hr>
 	<c:choose>
  			<c:when test="${user_id == book.user.id}">
 <div style="display:flex; ">
 <a href="/edit/book/${book.id }" style="margin-right:30px;"class="btn btn-success"> Edit </a>
 <div class="delete">
<form action='/book/delete/<c:out value="${book.id}"/>' method="post" class="delete">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete" class="btn btn-danger">
				</form>
				</div>
					</c:when>  
							</c:choose>
					

</div>
</body>
</html>