<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="content-header">
	<h1>Slide List</h1>
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath }/admin/dashboard"><i class="fa fa-dashboard"></i>Home</a></li>

		<li class="active">Slide List</li>
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
								
								<th>Photo</th>
								<th>Status</th>
								<th>Description</th>
								
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="slide" items="${slides}">
								<tr>
								<td>
								<img src="${pageContext.request.contextPath }/upload/images/${slide.name}" width="150">
								</td>
								
								<td>${slide.status ? "show" : "hide"}</td>
								<td>${slide.description}</td>
								<td>
									<a href="${pageContext.request.contextPath }/admin/slide/edit/${slide.id}" >Edit</a> 
									<a href="${pageContext.request.contextPath }/admin/slide/delete/${slide.id}" >Delete</a> 
									</td>
							</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Photo</th>
								<th>Status</th>
								<th>Description</th>
								
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