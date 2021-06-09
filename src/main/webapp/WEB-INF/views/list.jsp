<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>계좌목록</title>
</head>
<body>
	<h1>계좌목록</h1>	
		<!-- Table -->
		<table class="table">
			<tr>
				<td>계좌번호</td>
				<td>계좌주</td>
				<td>잔액</td>
				<td>통장내역</td>
			</tr>
			<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.ano}</td>
				<td>${vo.aname}</td>
				<td>${vo.balance}</td>
				<td><button onClick="location.href='read?ano=${vo.ano}'">거래내역</button></td>
			</tr>
			</c:forEach>
		</table>
	<!-- ----------------------- -->
	<nav>
	<ul class="pagination">
		<li><a href="list?page=${pm.startPage-1}" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
		</a></li>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			<li><a href="list?page=${i}">${i}</a></li>
		</c:forEach>
		<li><a href="list?page=${pm.endPage+1}" aria-label="Next"> <span
				aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
	</nav>
</body>
</html>