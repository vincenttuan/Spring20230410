<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
		<meta charset="UTF-8">
		<title>User Form</title>
	</head>
	<body style="padding: 15px">
		<spform:form class="pure-form"
					 method="post"
					 modelAttribute="user"
					 action="${pageContext.request.contextPath}/mvc/session11/user/">
			
			<input type="hidden" name="_method" id="_method" value="${ _method }">
			<button type="submit" class="pure-button pure-button-primary">${ submitButtonName }</button>
		</spform:form>
	</body>
</html>