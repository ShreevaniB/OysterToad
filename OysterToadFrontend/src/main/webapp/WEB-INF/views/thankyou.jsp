<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
<c:url value="/resourses/images/downpics" var="img"/>
<c:url value="/resourses/images/downpics" var="css"/>
</head>

<div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>OysterToad.com</strong>
                        <br>
                        P.O. Box 2012
                        <br>
                        Detroit, Mi 48000
                        <br>
                        <abbr title="Phone">P:</abbr> (213) 484-6829
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em>Date: August, 22 2018</em>
                    </p>
                    <p>
                        <em>Receipt #: 0000015</em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <img src="${img}/animated.jpg" alt="animated" width="180" height="180">
                    <h1>Receipt</h1>
                </div>
                </span>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>#</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <tr>
                            <td class="col-md-9"><em>Tilapia</em></h4></td>
                            <td class="col-md-1" style="text-align: center"> 1 </td>
                            <td class="col-md-1 text-center">Rs.576</td>
                            <td class="col-md-1 text-center">Rs.576</td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right">
                            <p>
                                <strong>Subtotal: </strong>
                            </p>
                            <p>
                                <strong>Tax: </strong>
                            </p></td>
                            <td class="text-center">
                            <p>
                                SGST:<strong>Rs.6.94</strong>
                            </p>
                            <p>
                                CGST:<strong>Rs.6.94</strong>
                            </p></td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><h4><strong>Total: </strong></h4></td>
                            <td class="text-center text-danger"><h4><strong>Rs.1152</strong></h4></td>
                        </tr>
                    </tbody>
                </table>
                <div>
                    <h1 style="text-align:center;">
                        Thank you for your order.
                    </h1>
                     
                </div>
            </div>
        </div>
    </div>
    
    <button class="subscribe btn btn-success btn-block" type="button"><a href="<c:url value="/"/>"> To Home </a></button>
                    <a href="<c:url value="/"/>"></a>  
                                   