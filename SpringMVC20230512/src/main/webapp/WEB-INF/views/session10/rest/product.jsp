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
		<title>Rest Product</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" 
			  method="post" 
			  action="${pageContext.request.contextPath}/mvc/product/rest/">
			
			<fieldset>
				<legend>Rest Product Form</legend>
				商品名稱: <input type="text" placeholder="請輸入商品名稱" id="name" name="name"><p/>
				商品數量: <input type="number" placeholder="請輸入商品數量" id="quantity" name="quantity"><p/>
				商品價格: <input type="number" placeholder="請輸入商品價格" id="price" name="price"><p/>
				<button type="submit" class="pure-button pure-button-primary" >Add</button>
			</fieldset>
				  
			  
		</form>

	</body>
</html>