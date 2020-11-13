<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span9">
	<div class="well well-small">
		<h4>
			Featured Products <small class="pull-right">200+ featured
				products</small>
		</h4>
		<div class="row-fluid">
			<div id="featured" class="carousel slide">
				<div class="carousel-inner">
					<div class="item next left">
						<ul class="thumbnails">
						<c:forEach var="product" items="${featuredProducts }">
						<c:set var="photo" value="${product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get() }"></c:set>
							<li class="span3">
								<div class="thumbnail">
									<i class="tag"></i> <a href="${pageContext.request.contextPath}/product/details/${product.id }"><img
										src="${pageContext.request.contextPath}/uploads/images/${photo.name}" 
										alt=""></a>
									<div class="caption">
										<h5>${product.name }</h5>
										<h4>
											<a class="btn" href="${pageContext.request.contextPath}/product/details/${product.id }">VIEW</a> <span
												class="pull-right">${product.price }</span>
										</h4>
									</div>
								</div>
							</li>
							</c:forEach>
							
							
						</ul>
					</div>	
				</div>
				<a class="left carousel-control" href="#featured" data-slide="prev">&lsaquo;</a>
				<a class="right carousel-control" href="#featured" data-slide="next">&rsaquo;</a>
			</div>
		</div>
	</div>
	
	
	<h4>Latest Products</h4>
	<ul class="thumbnails">
	<c:forEach var="product" items="${latestProducts }">
	<c:set var="photo" value="${product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get() }"></c:set>
		<li class="span3">
			<div class="thumbnail">
				<a href="${pageContext.request.contextPath}/product/details/${product.id }"><img
					src="${pageContext.request.contextPath}/uploads/images/${photo.name }" alt=""></a>
				<div class="caption">
					<h5>${product.name }</h5>
					<p>${product.description }</p>

					<h4 style="text-align: center">
						<a class="btn" href="${pageContext.request.contextPath}/product/details/${product.id }"> <i
							class="icon-zoom-in"></i></a> 
						<a class="btn" href="${pageContext.request.contextPath }/cart/buy/${product.id}">Add to <i
							class="icon-shopping-cart"></i></a>
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/product/details/${product.id }">${product.price }</a>
					</h4>
				</div>
			</div>
		</li>
		
	</ul>
</c:forEach>
</div>
