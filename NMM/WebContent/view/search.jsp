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
	<jsp:include page="top.jsp" />

	검색 결과 표시

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
				<td><a
					href='${servlet}qna&command=delete&productNo=${productDTO.productNo}'>삭제하기</a></td>
		</c:forEach>
	</table>


	<jsp:include page="footer.jsp" />
</body>
</html>