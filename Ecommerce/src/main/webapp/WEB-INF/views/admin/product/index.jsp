<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content-header">
	<h1>Product List</h1>
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath }/admin/dashboard"><i class="fa fa-dashboard"></i>Home</a></li>

		<li class="active">Product List</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-xs-12">

			<c:if test="${error != null }">
				<div class="alert alert-danger alert-dismissible">
					
					${error }
				</div>
			</c:if>

			<div class="box">
				
				<!-- /.box-header -->
				<div class="box-body">
					<table id="categoryList" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Price</th>
								<th>Category</th>
								<th>Featured</th>
								<th>Status</th>
								<th>Action</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products }">
								<tr>
									<td>${product.id }</td>
									<td>${product.name }</td>
									<td>${product.price }</td>
									<td>${product.categorys.name }</td>
									<td>${product.featured ? "featured" : "" }</td>
									<td>${product.featured ? 'Show' : 'Hide' }</td>
									<td>
									<a href="${pageContext.request.contextPath }/admin/product/edit/${product.id }" >Edit</a> 
									| 
									<a href="${pageContext.request.contextPath }/admin/product/delete/${product.id }" onclick="return confirm('Are you sure?')">Delete</a>
									|
									<a href="${pageContext.request.contextPath }/admin/photo/product/${product.id }" >Photos</a>
									|
									<a href="${pageContext.request.contextPath }/admin/photo/add/${product.id }" >Add Photo</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Price</th>
								<th>Category</th>
								<th>Featured</th>
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