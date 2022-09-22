	<%@page import="dao.ListProductDao, model.Product, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.servletContext.contextPath}/style/style2.css" />
</head>
<body>

<jsp:include page="/header.jsp" />
<h4 style="text-align: center;color: red;">${mess}</h4>
<div class="container">
	<div class="row">
	    <div class="col-sm-9">
	        <div class="row">	        
	            <c:forEach items="${list}" var="ls">
	                <div class="col-12 col-md-6 col-lg-4">
	                    <div class="card">		           
	                        <img class="card-img-top" src="${ls.src}" alt="Card image cap">
	                        <div class="card-body">
	                            <h4 class="card-title show_txt"><a href="<c:url value="InformationProductController?action=infor&infor=${ls.id}" />"
	                             title="View Product">${ls.name}</a></h4>
	                            <p class="card-text show_txt">${ls.description}</p>
	                            <div class="row">
	                                <div class="col">
	                                    <p class="btn btn-danger btn-block">${ls.price} $</p>
	                                </div>
	                                <div class="col">
	                                    <a href="${pageContext.request.servletContext.contextPath}/addtocart?action=add&id=${ls.id}" class="btn btn-success btn-block">Add to cart</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </c:forEach>
	        </div>
	    </div>
	</div>
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>