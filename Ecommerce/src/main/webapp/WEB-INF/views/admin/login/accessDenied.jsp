<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Access Denied to Admin Panel</h3>
${msg}
<br>
<a href="${pageContext.request.contextPath }/admin-panel">Back</a> 
</body>
</html>