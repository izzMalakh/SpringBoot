<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
a{
margin-right:30px;
font-size:2rem;
}
span{
font-size:4rem;
color:red;
}
</style>
</head>
<body>
<div class="container">
		<h2>You have visited http://http://localhost:8080/ :: <span>${count}</span>  times </h2>
		<a href="/reset">Reset Counter</a>
		<a href="/double">2 visits</a>
		<a href="/">1 visit</a>
		
	</div>
</body>
</html>