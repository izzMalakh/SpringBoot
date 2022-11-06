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
<style>

form{padding:0 50px;}
form div{display:flex; align-items:center; justify-content:start; flex-wrap:wrap; padding-bottom:25px;}
form div span{width: 250px; display: block;}
form div input{width: calc(100% - 350px); padding:10px;}


.error{color:var(--red);}
#div{
display:flex;
justify-content:space-between;
}
body{
padding:30px;
}
</style>
<meta charset="UTF-8">
<title>Home Page </title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	
</head>
<body>

		<div id="div">
		<h2>Edit an Expense</h2> <h5><a href='/expenses'>go back</a></h5>
		</div>
		<form:form action="/api/update/${expense.id}" method="post" modelAttribute="expense">
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

</body>
</html>