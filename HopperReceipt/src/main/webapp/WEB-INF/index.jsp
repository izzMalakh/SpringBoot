<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Receipt Home Page</title>
</head>
<body>
	<h1>Customer Name: ${name}</h1> 
	<h2>Item name: ${item}</h2>
	<h2>Price: <c:out value="${price}" /> </h2>
	<h2>Description: <c:out value="${desc}" /></h2>
	<h2>Vendor: <c:out value="${vendor}" /></h2>

</body>
</html>