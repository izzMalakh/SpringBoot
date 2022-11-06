<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<title>Home Page </title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	
</head>
<body>
	<div class="container" >
	
		<h1>Save Travels!</h1>
		<table class="table" style="width:64%;">
  <thead>
    <tr>
      
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
            <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="expense" items="${ expenses }">
    <tr>
      
      <td><c:out value="${expense.title }"/></td>
      <td><c:out value="${expense.vendor }"/></td>
      <td>$<c:out value="${expense.amount }"/></td>
      
      <td><a href='/expense/edit/<c:out value="${expense.id}"/>'>edit</a> </td>
    </tr>
  		</c:forEach> 
  
  </tbody>
</table>
		
		<h2>Add an Expense</h2>
		<form:form action="/api/create" method="post" modelAttribute="expense">
 			<div>
 				<span>
 					<form:label path="title">Title</form:label>
 					<form:errors path="title" class="error"/>
 				</span>
 				<form:input type="text" path="title"  />
 			</div>
 	
 			 <div>
 			 	<span>
 					<form:label path="description">Description</form:label>
 					<form:errors path="description" class="error"/>
 				</span>
 				<form:input type="text" path="description"  />
 			</div>
 	
 			<div>
 				<span>
 					<form:label path="vendor">Vendor</form:label>
 					<form:errors path="vendor" class="error"/>
 				</span>
 				<form:input type="text" path="vendor"  />
 			</div>
 			
 			<div>
 				<span>
 					<form:label path="amount">Amount</form:label>
 					<form:errors path="amount" class="error"/>
 				</span>
 				<form:input type="number" path="amount"  />
 			</div>
 	
 			<input type="submit" value="Submit" /> 
 		</form:form>
 		
	</div>
</body>
</html>