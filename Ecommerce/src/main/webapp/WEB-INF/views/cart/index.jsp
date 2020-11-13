<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="breadcrumb">
		<li><a href="${pageContext.request.contextPath}/home">Home</a> <span class="divider">/</span></li>
		<li class="active"> SHOPPING CART</li>
    </ul>
	<h3>  SHOPPING CART [ <small>${countItems } Items(s)</small>]
	<a href="${pageContext.request.contextPath}/home" class="btn btn-large pull-right">
	<i class="icon-arrow-left"></i> Continue Shopping </a></h3>	
	<hr class="soft"/>
	
	<form method="post" action="${pageContext.request.contextPath}/cart/update">
	<table class="table table-bordered">
              <thead>
                <tr>
                  <th>Action</th>
                  <th>Product</th>
                  <th>Name</th>
                  <th>Quantity
                  <c:if test="${sessionScope.cart != null }">
                  <input type="submit" value="Update">
                  </c:if>
                  </th>
				  <th>Price</th>            
                  <th>Total</th>
				</tr>
              </thead>
              <tbody>
              <c:forEach  var="item" items="${sessionScope.cart }" varStatus="i">
              <c:set var="photo"
               value="${item.product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get() }"></c:set>
                <tr>
                <td align="center">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/cart/remove/${i.index}">
                <i class="icon-remove icon-white"></i>
                </a>
                </td>
                  <td> <img width="60" src="${pageContext.request.contextPath}/uploads/images/${photo.name}" alt=""/></td>
                  <td>${item.product.name }</td>
				  <td>
					
					<input  style="width:60px" type="number" name="quantities" value="${item.quantity }">
					
				  </td>
                  <td>${item.product.price }</td>
                  <td>${item.product.price * item.quantity}</td>
                </tr>
				</c:forEach>
				 <tr>
                  <td colspan="5" style="text-align:right"><strong>TOTAL</strong></td>
                  <td class="label label-important" style="display:block"> <strong> ${total } </strong></td>
                </tr>
                
				</tbody>
            </table>
</form>	
			
	<a href="${pageContext.request.contextPath}/home" class="btn btn-large"><i class="icon-arrow-left"></i> Continue Shopping </a>
	<a href="${pageContext.request.contextPath}/cart/checkout" class="btn btn-large pull-right">Checkout <i class="icon-arrow-right"></i></a>