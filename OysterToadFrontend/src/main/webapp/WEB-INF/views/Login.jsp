<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
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
    border: 2px solid pink; 
    color: powderblue; 
    background-image:url("${img}/siamese fighting fish5.jpg"); 
    } 
 body 
 { 
 background-image:url("${img}/wallpaper.jpg"); 
 } 
</style>
<%@include file="Header.jsp"%>
</head>


</head>
<body>
<div>
<c:url value="/j_spring_security_check" var="login"/>
<form:form action="${login}" method="post">

   <fieldset style="margin:200px 500px">
    <legend> Login </legend>
     User Name:<br>
     <input type="text" placeholder="abc" name="j_username" required> <br>
     Password:<br>
     <input type="password" placeholder="!%&$abc" name="j_password" required> <br><br>
     <input type="submit">
     <input type="reset">
     </fieldset>

</form:form>
</div>
</body>
<%@include file="Footer.jsp"%>
</html>
 