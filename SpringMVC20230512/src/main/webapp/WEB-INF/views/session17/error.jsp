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
		<title>錯誤處理頁面</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" 
					 method="get" 
					 action="${ referer }">
			<fieldset>
				<legend>錯誤處理頁面</legend>
				來源網頁: ${ referer }<p />
				錯誤訊息: ${ ex }<p />
				<button type="submit" class="pure-button pure-button-primary">返回</button>	
			</fieldset>
			
		</form>
		
	</body>
</html>