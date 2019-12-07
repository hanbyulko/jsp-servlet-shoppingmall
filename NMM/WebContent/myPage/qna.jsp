<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url("https://fonts.googleapis.com/css?family=Roboto:400,300");

.pagination-container {
	margin: 100px auto;
	text-align: center;
}

.pagination {
	position: relative;
}

.pagination a {
	position: relative;
	display: inline-block;
	color: #2c3e50;
	text-decoration: none;
	font-size: 1.2rem;
	padding: 8px 16px 10px;
}

.pagination a:before {
	z-index: -1;
	position: absolute;
	height: 100%;
	width: 100%;
	content: "";
	top: 0;
	left: 0;
	background-color: #2c3e50;
	border-radius: 24px;
	-webkit-transform: scale(0);
	transform: scale(0);
	transition: all 0.2s;
}

.pagination a:hover, .pagination a .pagination-active {
	color: #fff;
}

.pagination a:hover:before, .pagination a .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination .pagination-active {
	color: #fff;
}

.pagination .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination-newer {
	margin-right: 50px;
}

.pagination-older {
	margin-left: 50px;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../view/top.jsp" />
	<h2 class="table--title">1대1 문의</h2>
	<p>
	<table class="table">
		<tr>
			<th style='text-align: center'>게시글번호</th>
			<th style='text-align: center'>상품이름</th>
			<th style='text-align: center'>제목</th>
			<th style='text-align: center'>작성날짜</th>
			<th style='text-align: center'>답변상태</th>
		</tr>
		<c:forEach var="qnaDTO" items="${list}" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td><a href="javacript:void();" onclick="show()">${qnaDTO.productDTO.productName}</a></td>
				<td>${qnaDTO.qnaTitle}</td>
				<td>${qnaDTO.qnaDate}</td>
				<td>${qnaDTO.qnaResponseState}</td>
			</tr>
			<tr class='content'>
				<td>${qnaDTO.qnaResponseContent}'</td>
			</tr>
		</c:forEach>
	</table>

	<!-- 페이징처리 -->
	<nav class="pagination-container">
		<div class="pagination">
			<a class="pagination-newer"
				href="${servlet}qna&command=${command}&keyword=${keyword}&category=${category}&pageNo=${pageNo>1?pageNo-1:1}">PREV</a>
			<span class="pagination-inner"> <c:forEach var='i' begin='1'
					end='${pageCnt}'>
					<a class="${i==pageNo?'pagination-active':page}"
						href="${servlet}qna&command=${command}&category=${category}&keyword=${keyword}&pageNo=${i}">${i}</a>
				</c:forEach>
			</span> <a class="pagination-older"
				href="${servlet}qna&command=${command}&keyword=${keyword}&category=${category}&pageNo=${pageNo<pageCnt?pageNo+1:pageCnt}">NEXT</a>
		</div>
	</nav>


	<jsp:include page="qnaWrite.jsp" />
	<jsp:include page="../view/footer.jsp" />
	<script>
		$(function() {
			$(".content").hide()
		})
		function show() {
			$(".content").toggle()
		}
	</script>
</body>
</html>