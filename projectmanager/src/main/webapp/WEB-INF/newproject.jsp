<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width:1000px; height:1000px; padding:10px; margin:0 auto">
<h1>Create a project!</h1>

<form:form action="/projects/create" method="post" modelAttribute="project">
<form:input type="hidden"  path="lead" value="${thisuser.id}"/>

  <div class="form-group">
    <form:label  path="title">Title</form:label>
     <form:errors path="title" class="text-danger" />
    <form:input type="text" class="form-control"  aria-describedby="emailHelp"  path="title"></form:input>
    </div>
   
  <div class="form-group">
    <form:label  path="description">Description</form:label>
     <form:errors path="description" class="text-danger" />
    <form:input type="text" class="form-control"  aria-describedby="emailHelp"  path="description"></form:input>
    </div>
    
    
  <div class="form-group">
    <form:label path="dueDate">Due Date</form:label>
    <form:errors path="dueDate" class="text-danger" />
    <form:input type="date" class="form-control"  aria-describedby="emailHelp"  path="dueDate"></form:input>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
</body>

</html>