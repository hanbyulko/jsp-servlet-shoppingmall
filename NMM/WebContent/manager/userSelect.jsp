<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../view/top.jsp"></jsp:include>
	<p>
		상품관리 게시판입니다 <br> <br>
	<p>
	<table>
		<tr>
			<th>상품번호</th>
			<th>종류</th>
			<th>재고</th>
			<th>이름</th>
			<th>색상</th>
			<th>사이즈</th>
			<th>가격</th>
			<th>등록날짜</th>
			<th>삭제하기</th>
		</tr>
		<c:forEach var="productDTO" items="${list}">
			<tr>
				<td>${productDTO.productNo}</td>
				<td>${productDTO.productCategory}</td>
				<td>${productDTO.productStock}</td>
				<td>${productDTO.productName}</td>
				<td>${productDTO.productColor}</td>
				<td>${productDTO.productSize}</td>
				<td>${productDTO.productPrice}</td>
				<td>${productDTO.productResiDate}</td>
				<td><a href='${servlet}qna&command=delete&productNo=${productDTO.productNo}'>삭제하기</a></td>
		</c:forEach>
	</table>
	
	
	
	
		<style>
			p { margin:20px 0px; }
		</style>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col">
					<p><strong>Pagination</strong></p>
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</body>
<jsp:include page="../view/footer.jsp"></jsp:include>
</html>