<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
	<section id="Table">
  <div class="page-header">
    <h3>Product List</h3>
  </div>
  <div class="row-fluid">
    <div class="span12">
		<table class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Photo</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
          </tr>
        </thead>
        <tbody>
        <c:set var="total" value="0"></c:set>
        <c:forEach var="invoiceDetail" items="${invoice.invoiceDetails }">
        <c:set var="total" value="${total +  invoiceDetail.products.price * invoiceDetail.products.quantity}"></c:set>
        <c:set var="photo" value="${invoiceDetail.products.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get() }"></c:set>
          <tr>
            <td>${invoiceDetail.products.id }</td>
            <td>${invoiceDetail.products.name }</td>
            <td>
             <a href="${pageContext.request.contextPath}/product/details/${invoiceDetail.products.id }"><img
										src="${pageContext.request.contextPath}/uploads/images/${photo.name}" 
										alt=""></a> 
            </td>
            <td>${invoiceDetail.products.price }</td>
            <td>${invoiceDetail.products.quantity }</td>
            <td>${invoiceDetail.products.price * invoiceDetail.products.quantity}</td>
          </tr>
          </c:forEach>
          <tr>
          <td colspan="5" align="right">Total</td>
          <td>$${total }</td>
          </tr>
        </tbody>
      </table>
	</div>
	
	</div>
	<a href="${pageContext.request.contextPath }/customer/history" class="btn btn-large"><i class="icon-arrow-left"></i>History</a>
</section>