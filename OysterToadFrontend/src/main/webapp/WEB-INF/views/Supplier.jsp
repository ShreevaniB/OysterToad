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
    border: 2px solid pink; 
    color: white; 
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

<c:url value="/addsup" var="sup"/>

<form:form action="${sup}" method="post" commandName="supplier">
<div>
   <fieldset style="margin-left:300px">
    <legend align="left"> Supplier </legend>
     Supplier Id:<br>
     <form:input type="text" placeholder="Enter Sup Id"  path="supId" required="required"/> <br>
     Supplier Name:<br>
     <form:input type="text" placeholder="Enter Name"  path="supName" required="required"/> <br>
     Supplier Address:<br>
     <form:input type="text" placeholder="Enter Address" path="supAddress" required="required"/><br>
     Supplier Email:<br>
     <form:input type="text" placeholder="Enter mail Id" path="supEmail_Id" required="required"/><br>
     Supplier Phone number:<br>
     <form:input type="text" placeholder="Enter number" path="supPhoneNum" required="required"/><br><br>
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
    <th>SupplierId</th>
    <th>SupplierName</th>
    <th>SupplierAddress</th>
    <th>SupplierEmail_Id</th>
    <th>SupplierPhone_Num</th>
    <th>Edit/Delete</th>
    </tr>
    <c1:forEach items="${suppliers}" var="sup">
    <tr>
    <td>${sup.getSupId()}</td>
    <td>${sup.getSupName()} </td>
    <td>${sup.getSupAddress()}</td>
    <td>${sup.getSupEmail_Id()}</td>
    <td>${sup.getSupPhoneNum()}</td>
    
    <td><a href="<c:url value="/editsupplier/${sup.getSupId()}"/>">Edit</a>
    <a href="<c:url value="/deletesupplier/${sup.getSupId()}"/>">Delete</a>
    </tr>
    </c1:forEach>
    
     </table>
</body>
<%@include file="Footer.jsp"%>
</html>
 																													