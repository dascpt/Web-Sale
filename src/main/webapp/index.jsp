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
<%
	String pageid = request.getParameter("page");
	if (pageid == null) {
		pageid = "1";
	}
	
	int start = Integer.parseInt(pageid);
	
	int total = 6;
	
	if (start == 1) {
	} else {
		start = start - 1;
		start = start * total + 1;
	}
	
	List<Product> list = ListProductDao.getProduct(start, total);
	request.setAttribute("list", list);
	Product last = ListProductDao.getLast();
	request.setAttribute("p", last);
	
%>
<jsp:include page="/header.jsp" />
<div class="container">
	<div class="row">
	    <div class="col-sm-3">
	        <div class="card bg-light mb-3">
	            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
	            <ul class="list-group category_block">
	                
	                    <li class="list-group-item text-white"><a href="#">iPhone</a></li>
	                    <li class="list-group-item text-white"><a href="#">Samsung</a></li>
	                    <li class="list-group-item text-white"><a href="#">Oppo</a></li>
	                    <li class="list-group-item text-white"><a href="#">Xiaomi</a></li>
	                    <li class="list-group-item text-white"><a href="#">Vivo</a></li>
	                    <li class="list-group-item text-white"><a href="#">Realme</a></li>
	                    <li class="list-group-item text-white"><a href="#">Nokia</a></li>
	                    <li class="list-group-item text-white"><a href="#">Mobell</a></li>
	                    <li class="list-group-item text-white"><a href="#">Itel</a></li>
	                    <li class="list-group-item text-white"><a href="#">Masstel</a></li>
	                
	            </ul>
	        </div>
	        <div class="card bg-light mb-3">
	            <div class="card-header bg-success text-white text-uppercase">Last product</div>
	            <div class="card-body">
	                <img class="img-fluid" src="${p.src}" />
	                <h5 class="card-title">${p.name}</h5>
	                <p class="card-text">${p.description}</p>
	                <p class="bloc_left_price">${p.price} $</p>
	            </div>
	        </div>
	    </div>
	
	    <div class="col-sm-9">
	        <div class="row">
	            <c:forEach items="${list}" var="o">
	                <div class="col-12 col-md-6 col-lg-4">
	                    <div class="card">
	                        <img class="card-img-top" src="${o.src}" alt="Card image cap">
	                        <div class="card-body">
	                            <h4 class="card-title show_txt"><a href="<c:url value="InformationProductController?action=infor&infor=${o.id}" />"
	                            	title="View Product">${o.name}</a></h4>
	                            <p class="card-text show_txt">${o.description}</p>
	                            <div class="row">
	                                <div class="col">
	                                    <p class="btn btn-danger btn-block">${o.price} $</p>
	                                </div>
	                                <div class="col">
	                                    <a href="${pageContext.request.servletContext.contextPath}/addtocart?action=add&id=${o.id}" class="btn btn-success btn-block">Add to cart</a>
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
<div class="pagination">
	<span class="pag-item"><a href="index.jsp?page=1">1</a></span> <span class="pag-item"><a href="index.jsp?page=2">2</a></span> 
</div>
<jsp:include page="/footer.jsp" />
</body>
</html>