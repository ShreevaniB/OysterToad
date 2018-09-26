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
      <li class="active"><a href="#">Home</a></li>
       <c1:if test="${pageContext.request.userPrincipal.name!=null}">
        <security:authorize access="hasRole('ROLE_ADMIN')">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Admin <span class="caret"></span></a>
	
	
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/Category"/>">Add Category</a></li>
          <li><a href="<c:url value="/Supplier"/>">Add Supplier</a></li>
          <li><a href="<c:url value="/Product"/>">Add Product</a></li>
        </ul>
     </li>
      </security:authorize>
      </c1:if>
      <li><a href="<c:url value="/Aboutus"/>">About us</a></li>
	  <li><a href="<c:url value="/Contact"/>">Contact</a></li>
	  <li><a href="<c:url value="/Products"/>">Products</a></li>
	  <li><a href="<c:url value="/Payment"/>">Payment</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
   
    <c1:if test="${pageContext.request.userPrincipal.name!=null}">
    <li> <a href="<c:url value="/checkout"/>"><span class="glyphicon glyphicon-shopping-cart">${items}</span></a></li>
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

<style>
body
{ 
background-color:black;
}
</style>
  
  <div class="container" Style ="width : 100%;">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
      <li data-target="#myCarousel" data-slide-to="6"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="${img}/01arowana.jpg" alt="01arowana" style="width:100%; height:600px">
        </div>
      

      <div class="item">
        <img src="${img}/fishes-tropical-siamese-underwater-betta-psychedelic-fish-fighting.jpg" alt="fishes-tropical-siamese-underwater-betta-psychedelic-fish-fighting" style="width:100%; height:600px">
      </div>
    
      <div class="item">
        <img src="${img}/Platinum-Arowana-one-of-the-expensive-tropical-fish-600x380.jpg" alt="Platinum-Arowana-one-of-the-expensive-tropical-fish-600x380" style="width:100%; height:600px">
      </div>
      
        <div class="item">
        <img src="${img}/four eyed butterfly fish.jpg" alt="four eyed butterfly fish" style="width:100%; height:600px">
      </div> 
      
        <div class="item">
        <img src="${img}/siamese fighting fish2.jpg" alt="Siamese fighting fish2" style="width:100%; height:600px">
      </div>
     
        <div class="item">
        <img src="${img}/unknown_in_eat4.jpg" alt="unknown_in_eat4" style="width:100%; height:600px">
      </div>

        <div class="item">
        <img src="${img}/freshwater angel fish1.jpg" alt="freshwater angel fish1" style="width:100%; height:600px">
      </div>         
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</body>
<%@include file="Footer.jsp"%>
