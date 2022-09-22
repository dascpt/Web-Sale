<%-- 
    Document   : Detail
    Created on : Dec 29, 2020, 5:43:04 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
         <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
<jsp:include page="header.jsp" />
     <div class="container"> 
         <div class="col-sm-9">
             <div class="container">
                 <div class="card">
                     <div class="row">
                         <aside class="col-sm-5 border-right">
                         	<div class="card">
                    			<h4 style="text-align: center;" class="card-title show_txt">${product.name}</h4>     
                        		<img class="card-img-top" src="${product.src}" alt="Card image cap">
                    		</div>                     
                         </aside>
                         <aside class="col-sm-7">
                             <article class="card-body p-5">
                                 <p class="price-detail-wrap"> 
                                     <span class="price h3 text-warning"> 
                                         <span class="num">${product.price} $</span>
                                     </span> 
                                     <!--<span>/per kg</span>--> 
                                 </p> <!-- price-detail-wrap .// -->
                                 <dl class="item-property">
                                     <dt>Description</dt>
                                     <dd><p>${product.description} </p></dd>
                                 </dl>
                                 <hr>
                                 <div class="row">
                                     <div class="col-sm-5">
                                                                              </div> <!-- col.// -->
                                     
                                 </div> <!-- row.// -->
                                 <hr>
                                 <div class="col">
                                 	<a href="${pageContext.request.servletContext.contextPath}/addtocart?action=add&id=${product.id}" class="btn btn-success btn-block">Add to cart</a>
                                 </div>                            
                             </article> <!-- card-body.// -->
                         </aside> <!-- col.// -->
                     </div> <!-- row.// -->
                 </div> <!-- card.// -->
             </div>
         </div>
     </div>
 </div>
<jsp:include page="footer.jsp" />     
    </body>
</html>
