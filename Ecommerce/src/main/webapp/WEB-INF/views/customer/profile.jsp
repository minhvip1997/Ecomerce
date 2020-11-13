<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
	 <ul class="breadcrumb">
		<li><a href="${pageContext.request.contextPath }/home">Home</a> <span class="divider">/</span></li>
		<li class="active">Profile</li>
    </ul>
	<h3> Customer Profile</h3>	
	<div class="well">
	${err }
	<s:form class="form-horizontal" method="post" modelAttribute="customer"
	action="${pageContext.request.contextPath }/customer/profile">
		
		
		<div class="control-group">
			<label class="control-label" for="username">User Name <sup>*</sup></label>
			<div class="controls">
			  <s:input path="username" required="required" readonly="true"/>
			</div>
		 </div>
		 	  
	<div class="control-group">
		<label class="control-label" for="password">Password <sup>*</sup></label>
		<div class="controls">
		  <s:password path="password"/>
		</div>
	  </div>	  
		
<div class="control-group">
			<label class="control-label" for="fullname">Full Name <sup>*</sup></label>
			<div class="controls">
			   <s:input path="fullname" required="required"/>
			</div>
		 </div>
		
<div class="control-group">
			<label class="control-label" for="address">Address <sup>*</sup></label>
			<div class="controls">
			 <s:input path="address" required="required"/>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="email">Email <sup>*</sup></label>
			<div class="controls">
			  <s:input type="email" path="email" required="required"/>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="phone">Phone <sup>*</sup></label>
			<div class="controls">
			 <s:input path="phone"/>
			</div>
		 </div>
	<p><sup>*</sup>Required field	</p>
	
	<div class="control-group">
			<div class="controls">
				
				<input class="btn btn-large btn-success" type="submit" value="Save" />
				<s:hidden path="id"/>
			</div>
		</div>		
	</s:form>
</div>
