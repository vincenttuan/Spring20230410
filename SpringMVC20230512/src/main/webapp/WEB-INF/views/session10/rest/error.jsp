<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
		<title>Error</title>
	</head>
	<body style="padding: 15px">
		<form method="get" action="${pageContext.request.contextPath}/mvc/product/rest/">
			錯誤訊息: ${ message }<p />
			<button type="submit" class="pure-button pure-button-primary">Back</button>
		</form>
	</body>
</html>