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
			<th>이름</th>
			<th>색상</th>
			<th>사이즈</th>
			<th>가격</th>
			<th>등록날짜</th>
		</tr>
		<c:forEach var="productDTO" items="${list}">
			<tr>
				<td>${productDTO.qnaNo}</td>
				<td><a href="#" class=openMask>${productDTO.productDTO.productName}</a></td>
				<td>${productDTO.qnaTitle}</td>
				<td>${productDTO.qnaDate}</td>
				<td>${productDTO.qnaResponseState}</td>
				<td><a
					href='${servlet}qna&command=delete&qnaNo=${productDTO.qnaNo}'>삭제하기</a></td>
		</c:forEach>
	</table>
</body>
</html>