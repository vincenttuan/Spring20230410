<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body style="padding: 15px">
		<spform:form class="pure-form" method="post" modelAttribute="div"
					 action="${ pageContext.request.contextPath }/mvc/session17/div/">
		
		</spform:form>
		
	</body>
</html>