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
		<title>Rest Product Delete</title>
	</head>
	<body style="padding: 15px">
		<!-- 商品表單 -->
		<form class="pure-form" 
			  method="post" 
			  action="${pageContext.request.contextPath}/mvc/product/rest/${index}">
			<fieldset>
				<legend>Rest Product Form Delete</legend>
				index: ${ index }<p />
				<input type="hidden" name="_method" id="_method" value="DELETE">
				商品名稱: ${ product.name }<p/>
				商品數量: ${ product.quantity }<p/>
				商品價格: ${ product.price }<p/>
				<button type="submit" class="pure-button pure-button-primary" >Delete</button>
			</fieldset>
		</form>
		
	</body>
</html>