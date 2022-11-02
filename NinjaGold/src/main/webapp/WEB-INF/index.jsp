<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList" %><!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Gold Home Page</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
</head>
<body>
	    <h1>Your gold: <span> ${gold }</span> </h1>
    <div>
        
        <form action="/process_money/1" method="post">
            <h2>Farm</h2>
            <p>Earns 10-20 gold</p>
            <input type="submit" value="Find Gold!"/>
          </form>
             
        <form  action="/process_money/2" method="post">
            <h2>Cave</h2>
            <p>Earns 10-20 gold</p>
            <input type="submit" value="Find Gold!"/>
          </form>
        <form action="/process_money/3" method="post">
            <h2>House</h2>
            <p>Earns 10-20 gold</p>
            <input type="submit" value="Find Gold!"/>
          </form>
        <form action="/process_money/4" method="post">
            <h2>Casino</h2>
            <p>Earns / takes 0-50 gold </p>
            <input type="submit" value="Find Gold!"/>
          </form>
          
    </div>
    </div>
    <br>
    <br>
    <h1>Activiteies </h1>
        <div id="act_box">
        <ul>
        <% if(session.getAttribute("messages") != null){ %>
        		<% ArrayList<String> arr = (ArrayList<String>) session.getAttribute("messages"); %>
        		<% for(int i = arr.size() - 1; i >=0 ; i--) { %>
        			<% if(arr.get(i).startsWith("You e") || arr.get(i).startsWith("You C")) { %>
        				<li style = "color: green;"><%= arr.get(i) %></li>
        			<% } else { %>
        				<li style = "color: red;"><%= arr.get(i) %></li>
        			<% } %>
        		<% } %>
        <% } %>
        </ul>
      </div>
<br>
<a class="btn btn-danger" id="reset" href="/reset"> RESET GAME! </a>
<a class="btn btn-warning" id="reset" href="/clearDate"> Clear Your Activiteis! </a>
</body>
</html>