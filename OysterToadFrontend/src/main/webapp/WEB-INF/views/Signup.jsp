<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>

<c:url value="/resourses/images/downpics" var="img"/>
<c:url value="/resourses/images/downpics" var="css"/>



<%@include file="Header.jsp"%>
<style>
body
{ 
background-image:url("${img}/40906510.jpg");
}
</style>


</head>
<body>

 <c:url value="/adduse" var="use"/>
     <form:form action="${use}" method="post" commandName="user">
<div>
   <fieldset>
    <legend align="left"> SignUp </legend>
     User Id:<br>
     <form:input type="text" placeholder="123" path="useId" required="required"/> <br>
     User Name:<br>
     <form:input type="text" placeholder="abc" path="useName" required="required"/> <br>
     Create Password:<br>
     <form:input type="password" placeholder="!%&$abc" path="usePassword" required="required"/> <br>
     Confirm Password:<br>
     <input type="password" required/> <br>
     User Email:<br>
     <form:input type="text" placeholder="Enter mail" path="useEmail_id" required="required"/><br>
     User phone Number:<br>
     <form:input type="text" placeholder="Enter Number" path="usePhone_num" required="required"/><br>
     User Address:<br>
     <form:input type="text" placeholder="Enter Address" path="useAddress" required="required"/><br>
     User City:<br>
     <form:input type="text" placeholder="Enter City" path="useCity" required="required"/><br><br> 
     <input type="submit">
     <input type="reset">
      
      
     </fieldset>
     </div>
    </form:form>
    </body>
    <%@include file="Footer.jsp"%>

