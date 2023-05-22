<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	<p>		
	<!-- 電腦選號統計資料 -->
	
	<p>
	<!-- 電腦選號歷史紀錄資料 -->
	歷史紀錄:
	<table class="pure-table pure-table-bordered">
		<thread>
			<tr>
				<th>index</th>
				<th>號碼 1</th>
				<th>號碼 2</th>
				<th>號碼 3</th>
				<th>號碼 4</th>
				<th>號碼 5</th>
				<th>更新</th>
				<th>刪除</th>
			</tr>
		</thread>
		<tbody>
			<!-- 分析 List 集合 -->
			<c:forEach varStatus="status" var="lotto" items="${ lottos }">
				<tr>
					<td>${ status.index }</td>
					<!-- 分析 Set 集合 -->
					<c:forEach var="num" items="${ lotto }">
						<td>${ num }</td>
					</c:forEach>
					<td>
						<button type="button" class="pure-button pure-button-primary">更新</button>
					</td>
					<td>
						<button type="button" class="pure-button pure-button-primary">刪除</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>