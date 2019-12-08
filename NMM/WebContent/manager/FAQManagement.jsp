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
body {
	color: #2c3e50;
	font-family: 'Roboto', sans-serif;
	font-weight: 400;
}

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

</style>
</head>
<body>
	<jsp:include page="../view/top.jsp" />
	<h1 class="table--title">1대1 문의 관리</h1>
	<table class="table">
		<tr>
			<th>게시글번호</th>
			<th>상품이름</th>
			<th>제목</th>
			<th>작성날짜</th>
			<th>답변상태</th>
			<th>기능<th>
			<th>삭제하기<th>
		</tr>
		<c:forEach var="qnaDTO" items="${list}" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${qnaDTO.productDTO.productName}</td>
				<td>${qnaDTO.qnaTitle}</td>
				<td>${qnaDTO.qnaDate}</td>
				<td>${qnaDTO.qnaResponseState}</td>
				<td><a href="${servlet}qna&command=selectByQnaNo&qnaNo=${qnaDTO.qnaNo}">답변하기</a></td>
				<td><a href="${servlet}qna&command=delete&manage=1&qnaNo=${qnaDTO.qnaNo}">삭제하기</a></td>
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
	
	
	<jsp:include page="../view/footer.jsp" />
</body>
</html>