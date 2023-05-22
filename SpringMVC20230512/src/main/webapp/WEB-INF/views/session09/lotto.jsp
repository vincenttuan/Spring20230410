<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<meta charset="UTF-8">
	<title>Lotto</title>
</head>
<body style="padding: 15px">
	<!-- 電腦選號按鈕 -->
	<button type="button"
			onclick="window.location.href='${pageContext.request.contextPath}/mvc/lotto/add';"
			class="pure-button pure-button-primary">Lotto 539 電腦選號</button>
	<!-- 電腦選號統計資料 -->
	
	<!-- 電腦選號歷史紀錄資料 -->
	${ lottos }
</body>
</html>