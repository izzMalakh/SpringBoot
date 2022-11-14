<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
body{
padding-left:100px;
}

</style>
<title>Insert title here</title>
</head>
<body>
<h1>
Welcome ${thisuser.firstName } ${logged.lastName }
</h1>
<p> <a href="/logout">log out</a></p><a href="/add/project" class="btn btn-primary"> new project </a>

<h3> all projects</h3>
<table class="table">
  <thead class="thead-dark">
    <tr>
     
     
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
       <th scope="col">Actions</th>
     
      
     
    </tr>
  </thead>
  <tbody>
  <c:forEach var="project" items="${allunassprojects}">
  <c:if test="${loggedID != project.lead.id}" >
    <tr>
     
      
       <td><a href="/projects/${project.id}">${project.title}</a></td>
      
        <td><c:out value="${project.lead.firstName}"></c:out></td>
         <td><c:out value="${project.dueDate}"></c:out></td>
         
         <td>
           <a href="/jointeam/${project.id}">Join the team</a>
      </td>
      
       

      
    </tr>
    </c:if>
     </c:forEach>
  
    
  </tbody>
</table>

<h3> your projects</h3>
<table class="table">
  <thead class="thead-dark">
    <tr>
     
     
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
       <th scope="col">Actions</th>
     
      
     
    </tr>
  </thead>
 
  <tbody>
  <c:forEach var="project" items="${allassprojects}">
    <tr>
     
      
       <td><a href="/projects/${project.id}">${project.title}</a></td>
      
        <td><c:out value="${project.lead.firstName}"></c:out></td>
                      <td><c:out value="${project.dueDate}"></c:out></td>
    
         <c:if test="${thisuser.id != project.lead.id}" >
         <td>
           <a href="/leaveteam/${project.id}">leave team</a>
      </td>
      </c:if>
       
       <c:if test="${thisuser.id == project.lead.id}" >
         <td>
           <a href="/editproject/${project.id}">edit</a>
      </td>
      </c:if>

      
    </tr>
    
     </c:forEach>
  
     <c:forEach var="project" items="${myprojects}">
    <tr>
     
      
       <td><a href="/projects/${project.id}">${project.title}</a></td>
      
        <td><c:out value="${project.lead.firstName}"></c:out></td>
         <td><c:out value="${project.dueDate}"></c:out></td>
         <c:if test="${thisuser.id != project.lead.id}" >
         <td>
           <a href="/leaveteam/${project.id}">leave team</a>
      </td>
      </c:if>
       
       <c:if test="${thisuser.id == project.lead.id}" >
         <td>
           <a href="/editproject/${project.id}">edit</a>
           <a href="/project/delete/${project.id}">delete</a>
      </td>
      </c:if>

      
    </tr>
    
     </c:forEach>
  </tbody>
</table>

</body>
</html>