<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content-header">
	<h1>Invoices List</h1>
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath }/admin/dashboard"><i
				class="fa fa-dashboard"></i>Home</a></li>

		<li class="active">Invoices List</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-xs-12">

			<c:if test="${error != null }">
				<div class="alert alert-danger alert-dismissible">${error }</div>
			</c:if>

			<div class="box">

				<!-- /.box-header -->
				<div class="box-body">
					<table id="categoryList" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Name</th>
								<th>Created</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="invoice" items="${invoices }">
								<tr>
									<td>${invoice.id }</td>
									<td>${invoice.name }</td>
									<td>${invoice.created }</td>
									<td>${invoice.status }</td>
									<td><a class="btn"
										href="${pageContext.request.contextPath }/admin/invoice/details/${invoice.id }">Details</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>#</th>
								<th>Name</th>
								<th>Created</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
						</tfoot>
					</table>
				</div>
				<!-- /.box-body -->
			</div>



		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>
<script>
	$(function() {

		$('#categoryList').DataTable({
			'paging' : true,
			'lengthChange' : false,
			'searching' : false,
			'ordering' : true,
			'info' : true,
			'autoWidth' : false
		})
	})
</script>