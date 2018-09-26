<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
   
<!DOCTYPE html>
<html>
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'> 

<c:url value="/resourses/images/downpics" var="img"/>
<c:url value="/resourses/images/downpics" var="css"/>

   <link rel="stylesheet" href="css/style.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
    <ul class="nav navbar-nav">
      <li class="active"><a href="<c:url value="/"/>">Home</a></li>
       <c1:if test="${pageContext.request.userPrincipal.name!=null}">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Admin <span class="caret"></span></a>
	
	 <security:authorize access="hasRole('ROLE_ADMIN')">
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/Category"/>">Add Category</a></li>
          <li><a href="<c:url value="/Supplier"/>">Add Supplier</a></li>
          <li><a href="<c:url value="/Product"/>">Add Product</a></li>
        </ul>
		</security:authorize>
		
      </li></c1:if>
      <li><a href="<c:url value="/Aboutus"/>">About us</a></li>
	  <li><a href="<c:url value="/Contact"/>">Contact</a></li>
	  <li><a href="<c:url value="/Products"/>">Products</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
   
    <c1:if test="${pageContext.request.userPrincipal.name!=null}">
    <li> <a href="<c:url value="/checkout"/>"><span class="glyphicon glyphicon-shopping-cart">${cartitems}</span></a></li>
    </c1:if>
    <c1:if test="${pageContext.request.userPrincipal.name==null}">
	
	</c1:if>
	<c1:if test="${pageContext.request.userPrincipal.name==null}">
	     <li><a href="<c:url value="/User"/>"><span class="glyphicon glyphicon-log-out"></span> SignUp</a></li>
	  </c1:if>
	  <c1:if test="${pageContext.request.userPrincipal.name!=null}">
      <li><a href="<c:url value="j_spring_security_logout"/>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </c1:if>
      <c1:if test="${pageContext.request.userPrincipal.name==null}">
	  <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	  </c1:if>
    </ul>
  </div>
</nav>
</body>
</html>