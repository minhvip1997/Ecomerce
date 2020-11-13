<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content-header">
	<h1>Invoices Details</h1>
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath }/admin/dashboard"><i
				class="fa fa-dashboard"></i>Home</a></li>

		<li class="active">Invoices Details</li>
	</ol>
</section>
 <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="fa fa-globe"></i>${invoice.name } (#${invoice.id })
            <small class="pull-right">${invoice.created }</small>
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <div class="row invoice-info">
       
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">
          To
          <address>
            <strong>${invoice.account.fullname }</strong><br>
           ${invoice.account.address }<br>
            
            Phone: ${invoice.account.phone }<br>
            Email: ${invoice.account.email }
          </address>
        </div>
        <!-- /.col -->
       
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Photo</th>
              <th>Price</th>
              <th>Quantity</th>
             
              <th>Subtotal</th>
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
										width="70"></a> 
            </td>
            <td>${invoiceDetail.products.price }</td>
            <td>${invoiceDetail.products.quantity }</td>
            <td>${invoiceDetail.products.price * invoiceDetail.products.quantity}</td>
          </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <div class="row">
       
        <div class="col-xs-6">
        

          <div class="table-responsive">
            <table class="table">
              
              <tr>
                <th>Total:</th>
                <td>${total }</td>
              </tr>
            </table>
          </div>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <!-- this row will not appear when printing -->
      <c:if test="${invoice.status == 'pending' }">
      <div class="row no-print">
        <div class="col-xs-12">
        
          <a href="${pageContext.request.contextPath }/admin/invoice/update/${invoice.id }" 
          class="btn btn-primary pull-right" style="margin-right: 5px;">
           Update
          </a>
         
        </div>
        </c:if>
      </div>
    </section>