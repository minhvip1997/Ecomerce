<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3> Login</h3>	
	<hr class="soft"/>
	
	<div class="row">
		<div class="span9">
			<div class="well">
			${msg }
			<form method="post" action="${pageContext.request.contextPath}/customer/process-login">
			  <div class="control-group">
				<label class="control-label" for="username">Username</label>
				<div class="controls">
				  <input class="span3"  type="text" id="username" name="username">
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="password">Password</label>
				<div class="controls">
				  <input class="span3"  type="password" id="password" name="password">
				</div>
			  </div>
			  <div class="controls">
			  <button type="submit" class="btn block">Login</button>
			  <br>
			  <a href="${pageContext.request.contextPath }/customer/register">Register</a>
			  </div>
			</form>
		</div>
		</div>
		
	</div>	