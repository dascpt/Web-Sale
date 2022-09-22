<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link href="${pageContext.request.servletContext.contextPath}/style/style2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
   <!--begin of menu-->
   <nav class="navbar navbar-expand-md navbar-dark bg-dark">
       <div class="container">
           <a class="navbar-brand" href="${pageContext.request.servletContext.contextPath}/index.jsp" >Phones</a>
           <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
           </button>

           <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
               <ul class="navbar-nav m-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="${pageContext.request.servletContext.contextPath}/index.jsp">Home</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" href="#">Products</a>
                   </li>
                    <li class="nav-item">
                       <a class="nav-link" href="#">About Us</a>
                   </li>
                   <c:if test="${sessionScope.acc != null}">
                   		<li class="nav-item">
                       		<a class="nav-link" href="#">Hello ${sessionScope.acc.username}</a>
                   		</li>		
                   		<li class="nav-item">
                       		<a class="nav-link" href="logout" />Logout</a>
                   		</li>
                   </c:if>
                   <c:if test="${sessionScope.acc == null}">
	                   <li class="nav-item">
	                       <a class="nav-link" href="login.jsp" />Login</a>
	                   </li>
                   </c:if>
               </ul>

               <form action="SearchController2" method="get" class="form-inline my-2 my-lg-0">
                   <div class="input-group input-group-sm">
                       <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                       <div class="input-group-append">
                           <button type="submit" class="btn btn-secondary btn-number">
                               <i class="fa fa-search"></i>
                           </button>
                       </div>
                   </div>
                   <c:if test="${sessionScope.acc != null}">		                   							                   		
	                    <a class="btn btn-success btn-sm ml-3" href="pay.jsp">
                       		<i class="fa fa-shopping-cart"></i> Cart
                       		<span class="badge badge-light"></span>
                   		</a>			                   	
         			</c:if>
                    <c:if test="${sessionScope.acc == null}">
                    	<a class="btn btn-success btn-sm ml-3" href="cart.jsp">
                       		<i class="fa fa-shopping-cart"></i> Cart
                       		<span class="badge badge-light"></span>
                   		</a>				                   
                    </c:if>
               </form>
           </div>
       </div>
   </nav>
   <section class="jumbotron text-center">
       <div class="container">
           <h1 class="jumbotron-heading">Xả hàng tồn kho</h1>
           <p class="lead text-muted mb-0">giá rẻ như cho, không lo về giá</p>
       </div>
   </section>
   <!--end of menu-->
   <div class="container">
       <div class="row">
           <div class="col">
               <nav aria-label="breadcrumb">
                   <ol class="breadcrumb">
                       <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                       <li class="breadcrumb-item"><a href="#">Category</a></li>
                       <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                   </ol>
               </nav>
           </div>
       </div>
   </div>

</body>
</html>