<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<%@include file="Header.jsp"%>
<title>Cart</title>
</head>
<body>

<div class="container" style="margin-bottom:150px;margin-top:15px">
<table style="margin-top:100px;margin-left:100px;margin-bottom:50px;width:100%">
    <tr>
    <th>Image</th>
    <th>Name</th>
	<th>Price</th>
	<th>Total</th>
    </tr>
   
	<c1:forEach items="${cartItem}" var="Cart_Items">
    <tr>
    <td><img width="200px" height="200px" src="<c:url value="resourses/images/${Cart_Items.getProduct().getProId()}.jpg"/>"></td>
    <td>${Cart_Items.getProduct().getProName()}</td>
	<td>${Cart_Items.getProduct().getProPrice()}</td>
	<td>${Cart_Items.getCart().getGrand_total()}</td>
	<td><a href="<c:url value="/Buy/${Cart_Items.getProduct().getProId()}/${Cart_Items.getCart().getCart_Id()}"/>">
        <button type="submit" class="btn btn-default" style="margin-right:20px;width:60%;height:50px">Buy</button>
        </a></td>
	<td><a href="<c:url value="/Remove/${Cart_Items.getCartItems_Id()}"/>">
        <button type="submit" class="btn btn-default" style="margin-left:20px;width:60%;height:50px">Remove</button>
        </a></td>
	</tr>    
	</c1:forEach></table>


<a href="<c:url value="/Buyall"/>">
        <button type="submit" class="btn btn-default" style="margin-left:25px;width:10%;height:50px">Buy All</button>
        </a>
        
<a href="<c:url value="/RemoveAll"/>">
        <button type="submit" class="btn btn-default" style="margin-left:25px;width:10%;height:50px">Remove All</button>
        </a>

</div>

</body>
<%@include file="Footer.jsp"%>
</html>