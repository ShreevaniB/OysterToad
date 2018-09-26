<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<c:url value="/resourses/images/downpics" var="img"/>
<c:url value="/resourses/images/downpics" var="css"/>

<style>



h2
{
  text-align:center;
}
body
{
background-image:url("${img}/wallpaper1.jpg");
}

div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}
</style>
<%@include file="Header.jsp"%>
<h2> ALL FISHES </h2>
</head>
<body>

<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/Acara-Bandeira-Cinza.jpg" alt="Acara-Bandeira-Cinza" style="width:"600"; height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Fish that is found in the nothern asia</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->


<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/angelfish-218086_960_720.jpg" alt="angelfish-218086_960_720" width="600" height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Fish that is most beautiful</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->

<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/clown fish3.jpg" alt="clown fish3" width="600" height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Clown Fish</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->

<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/\MEU.jpg" alt="MEU" width="600" height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">MEU</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->

<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/freshwater angel fish1.jpg" alt="freshwater angel fish1" width="600" height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Angel fish</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->
<!-- <br> -->


<!-- <h2> EDIBLE FISHES</h2> -->

<style>



h2
{
  text-align:center;
}
body
{
background-image:url("${img}/wallpaper1.jpg");
}

div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}
</style>
</head>
<body>

<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/Canned Mackerel Fish_in_eat.jpg" alt="Canned Mackerel Fish_in_eat" style="width:"600"; height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Canned Mackerel</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->


<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/Saithe  _in_eat.jpg" alt="Saithe  _in_eat" width="600" height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Saithe</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->

<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/unknown_in_eat4.jpg" alt="unknown_in_eat4" width="600" height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Milk Fish</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->

<!-- <div class="gallery"> -->
<!--   <a target="_blank" href="/addtocart/{proid}"> -->
<%--     <img src="${img}/rani-fish_in_eat.jpg" alt="rani-fish_in_eat" width="600" height="400"> --%>
<!--   </a> -->
<!--   <div class="desc">Rani Fish</div> -->

<!-- <button>Add to cart</button> -->
<!-- <button> Buy</button> -->
<!-- </div> -->
<div>
<div class="gallery">
<c1:forEach items="${products}" var="pro">
    
   <a target="_blank" href="/addtocart/{proid}">
    <img src="resourses/images/${pro.getProId()}.jpg" alt="img" width="600" height="400">
  </a>
  <div class="desc">Tilapia</div>
 

<a href="<c:url value='/addtocart/${pro.getProId()}'/>">Addtocart</a>
<button>  <a href="<c:url value='/buyproduct/${pro.getProId()}'/>">Buy</a></button>
  </c1:forEach>
</div>
</div>


<%-- <c1:forEach items="${products}" var="pro"> --%>
    
<%--     <a href="<c:url value="/addtocartproduct/${pro.getProId()}"/>">Add to cart</a> --%>
<%--     <a href="<c:url value="/buyproduct/${pro.getProId()}"/>">Buy</a> --%>
    
<%--     </c1:forEach> --%>

</body>
<%-- <%@include file="Footer.jsp" %> --%>
</html>

