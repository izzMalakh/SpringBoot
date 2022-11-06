<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
#add{
border:1px solid black;
border-radius:10px 0px 10px 0px;
width:19.5%;
margin-left:30px;
padding:10px;
}
</style>
<meta charset="ISO-8859-1">
<title>all Expenses</title>

</head>
<body>
<h1>Save Travels!</h1>
<table class="table" style="width:60%; margin-left:100px; margin-top:20px;">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">edit</th>
      <th scope="col">delete</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="expense" items="${ expenses }">
    <tr>
      <th scope="row">1</th>
      <td><a href='expense/<c:out value="${expense.id}"/>'><c:out value="${expense.title }"/></a></td>
      <td><c:out value="${expense.vendor }"/></td>
      <td><c:out value="${expense.amount }"/></td>
       <td><a href='/expense/edit/<c:out value="${expense.id}"/>' class="edit">edit</a></td>
        <td><form action='/expense/delete/<c:out value="${expense.id}"/>' method="post" class="delete">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
				</form>  </td>
        
    </tr>
    </c:forEach> 
    
  </tbody>
  </table>


	



		
</body>
</html>