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
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<meta charset="UTF-8">
<title> book club</title>
</head>
<body>
	<div class="container">
		<nav>
			<a href="/dashboard">Dashboard</a> |
			<a href="/add/book">Add Book</a> |
			<a href="/logout">Logout</a>
		</nav>
		<h2> <a href="/bookmarket"> Go to the book Market </a></h2>
		<h1 style="padding-bottom:0;">Welcome  ${logged.firstName }!</h1>
		<h3 style="padding:0;">Here you will find all books! </h3>
		
		<c:choose>
  			<c:when test="${allBooks.size() == 0}">
				<h3 class="gold">No books at this time</h3>
				<div class="button-wrp">
			<a href="/add/book" class="button">Add Book</a>
		</div>
  			</c:when>

  			<c:otherwise>
  			<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">title</th>
      <th scope="col">author</th>
      <th scope="col">posted by</th>
      <th scope="col">creat at</th>
      <%-- <th scope="col">update at</th> --%>
      
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>

  <c:forEach var="book" items="${allBooks }">
   <tr>
      <th scope="row"></th>
      <td><a href="/book/${book.id}">${book.title }</a></td>
      <td>${book.author }</td>
      <td>${book.user.firstName} ${book.user.lastName}</td>
       <td><fmt:formatDate value="${book.createdAt}" pattern="yyyy-MM-dd HH:mm" /></td>
            <%-- <td><fmt:formatDate value="${book.updatedAt}" pattern="EEEE-dd-MMMM-yyyy" /></td> --%>
        
       
      <td>
       
       	<c:choose>
  		  			<c:when test="${loggedID == book.user.id}">
  		  			
  		  			<div class="delete">
<a href="/book/delete/<c:out value="${book.id}"/>">delete</a>
				</div>
				</c:when>  
				</c:choose>
				
      </td>
    </tr>
					
</c:forEach>
   </c:otherwise>
		</c:choose>

  </tbody>
</table>
  			
  			
			
		
	</div>
</body>
</html>