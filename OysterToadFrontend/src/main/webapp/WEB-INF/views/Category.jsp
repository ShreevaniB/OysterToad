<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>

<c:url value="/resourses/images/downpics" var="img"/>
<c:url value="/resourses/images/downpics" var="css"/>
<style>
#id1{
    width: 300px; 
    margin: 200px 400px 100px 500px; 
    border: 2px solid pink; ji
    color: powderblue; 
    background-image:url("${img}/siamese fighting fish5.jpg"); 
    } 
 body 
 { 
 background-image:url("${img}/40906510.jpg"); 
 } 
</style>
<%@include file="Header.jsp"%>
</head>
<body>

<c:url value="/addcat" var="cat"/>

<form:form action="${cat}" method="post" commandName="category">
<div id="id1">
   <fieldset>
    <legend align="left"> Category </legend>
     Category Id:<br>
     <form:input type="text" placeholder="category Id" path="catId" required="required"/> <br>
     Category Name:<br>
     <form:input type="text" placeholder="Category Name" path="catName" required="required"/> <br><br>
     <input type="submit">
     <input type="reset">
     </fieldset>
     </div>
</form:form>
<br>
<br>
<br>
<br>
     
    <table border="1px solid black" style="float:left;margin:-140px 70px 10px 670px;border-collapse:collapse;">
    <tr>
    <th>CategoryId</th>
    <th>CategoryName</th>
    <th>Edit/Delete</th>
    </tr>
    <c1:forEach items="${categories}" var="cat">
    <tr>
    <td>${cat.getCatId()}</td>
    <td>${cat.getCatName()} </td>
    <td><a href="<c:url value="/editcategory/${cat.getCatId()}"/>">Edit</a>/
    <a href="<c:url value="/deletecategory/${cat.getCatId()}"/>">Delete</a>
    </tr>
    </c1:forEach>
    
     </table>

</body>
<%@include file="Footer.jsp"%>
</html>