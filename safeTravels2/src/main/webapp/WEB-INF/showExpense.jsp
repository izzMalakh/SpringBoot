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
p{
font-size:1.4rem;
}
</style>
<meta charset="UTF-8">
<title>Single Expense</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
	<div style="display:flex; justify-content:space-around;">
		<h1>Expense Details </h1>
		<h3><a href="/expenses">Go back</a></h3>
		</div>
		<div style="margin-left:300px;">
		<p><strong>Expense Name:</strong>${expense.title}</p>
		<p><strong>Vendor:</strong> ${expense.vendor }</p>
		<p><strong>Description:</strong> ${expense.description }</p>
		<p><strong>Amount: </strong><span>$</span> ${expense.amount }</p>
		</div>
	</div>
</body>
</html>