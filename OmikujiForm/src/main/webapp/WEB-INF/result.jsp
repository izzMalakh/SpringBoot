<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Info Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<style>
	#box{
	height:auto;
	width:30%;
	background-color:#38c0f9;
	padding:10px;
	word-wrap: break-word;
	
	}
	</style>
</head>
<body>
<h1>Here's Your Omikuji!</h1>

		
		
		
			<div id="box">
				In ${number} years, you will
				live in ${city} with ${person} 
				as your roommate, ${hobby} for a living. The
				next time you see a ${thing}, you will have good
				luck. Also, ${message}.
			</div>
		
		
		
	
	<a href="/omikuji">Go Back</a>

</body>
</html>