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
		<title>Rest Product Update</title>
	</head>
	<body style="padding: 15px">
		<!-- 商品表單 -->
		<form class="pure-form" 
			  method="post" 
			  action="${pageContext.request.contextPath}/mvc/product/rest/${index}">
			<fieldset>
				<legend>Rest Product Form Update</legend>
				index: ${ index }<p />
				<input type="hidden" name="_method" id="_method" value="PUT">
				商品名稱: <input value="${ product.name }" type="text" placeholder="請輸入商品名稱" id="name" name="name"><p/>
				商品數量: <input value="${ product.quantity }" type="number" placeholder="請輸入商品數量" id="quantity" name="quantity"><p/>
				商品價格: <input value="${ product.price }" type="number" placeholder="請輸入商品價格" id="price" name="price"><p/>
				<button type="submit" class="pure-button pure-button-primary" >Update</button>
			</fieldset>
		</form>
		
	</body>
</html>