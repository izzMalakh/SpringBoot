<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<a href="/languages">Dashboard</a>
		
		<h1>${ language.name}</h1>
		<p>Creator: ${ language.creator}</p>
		<p>Version: ${ language.version}</p>
		
	</div>
</body>
</html>