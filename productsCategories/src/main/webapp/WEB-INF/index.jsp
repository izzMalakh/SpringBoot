<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
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
#home{
margin:0 auto;
width:30%;
margin-bottom:30px;
margin-top:30px;
text-align:center;
}
.container{
width:1000px;
border: 1px solid gray;
margin-top:10px;
}
td{
list-style:none;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container">
<div id="home">
<h1>Home Page</h1>
<br>
 <th scope="col"><a href="/categorys/addpage" class="btn btn-success">Add New Category</a></th>
      <th scope="col"><a href="/products/addpage" class="btn btn-secondary">Add New Product</a></th>
</div>
<hr>
<br>

<table class="table" style="text-align:center;">
  <thead>
    <tr>

      <th scope="col"><a href="#" >Categorys</a></th>
      <th scope="col"><a href="#" >Products</a></th>
    </tr>
  </thead>
    <tbody>
    <tr>
      
      <td>
<c:forEach var="catergory" items="${cats}">
                        <li><a href="/category/${catergory.id}"><c:out value="${catergory.name}"></c:out></a></li>
                    </c:forEach>
</td>
      <td>
      <c:forEach var="product" items="${pros}">
                        <li><a href="/products/${product.id}"><c:out value="${product.name}"></c:out></a></li>
                    </c:forEach>
      </td>
    </tr>

  </tbody>
</table>
</div>
</body>
</html>