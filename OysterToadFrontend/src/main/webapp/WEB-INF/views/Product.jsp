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

<c:url value="/addproduct" var="pro"/>

<form:form action="${pro}" method="post" commandName="product" enctype="multipart/form-data">
<div>
   <fieldset>
    <legend align="left">Product</legend>
     Product Id:<br>
     <form:input type="text" placeholder="Enter   Id"  path="proId" required="required"/> <br>
     Product Name:<br>
     <form:input type="text" placeholder="Enter Name"  path="proName" required="required"/> <br>
     Price:<br>
     <form:input type="text" placeholder="Enter Price" path="proPrice" required="required"/><br>
     Quantity:<br>
     <form:input type="text" placeholder="Enter Quantity" path="proQuantity" required="required"/><br>
     Product Description:<br>
     <form:input type="text" placeholder="Enter Description" path="proDescription" required="required"/><br><br>
     
     Category:
     <form:select path="category.catId">
     <c1:forEach items="${categories}" var="cat">
     <option value="cat.getCatId()">${cat.getCatName()}</option>
     </c1:forEach> 
     </form:select>
     
     Supplier:
     <form:select path="supplier.supId">
     <c1:forEach items="${suppliers}" var="sup">
     <option value="sup.getSupId()">${sup.getSupName()}</option>
     </c1:forEach> 
     </form:select>
     Product Images:
     <form:input type="file" value="Upload Value" path="pimg"/>
     
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
    <th>ProductId</th>
    <th>Product Image</th>
    <th>ProductName</th>
    <th>ProductPrice</th>
    <th>ProductQuantity</th>
    <th>ProductDescription</th>
    <th>Edit/Delete</th>
    </tr>
    <c1:forEach items="${products}" var="pro">
    <tr>
    <td>${pro.getProId()}</td>
    <td><img height="250px" width="250px" src="<c:url value="/resourses/images/${pro.getProId()}.jpg"/>"></td>
    <td>${pro.getProName()} </td>
    <td>${pro.getProPrice()}</td>
    <td>${pro.getProQuantity()}</td>
    <td>${pro.getProDescription()}</td>
    
    <td><a href="<c:url value="/editproduct/${pro.getProId()}"/>">Edit</a>
    <a href="<c:url value="/deleteproduct/${pro.getProId()}"/>">Delete</a>
    </tr>
    </c1:forEach>
    
     </table>
</body>
</html>
 