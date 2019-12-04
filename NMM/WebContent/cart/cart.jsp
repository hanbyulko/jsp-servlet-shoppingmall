<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
      	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<meta name="viewport" content="width=device-width,initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900|Noto+Sans+KR:100,300,400,500,700,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
	table,tr,th,td{
	border: solid 1px black;
	}
</style>
</head>
<body>
<jsp:include page="../view/top.jsp"/>
<h1>CART페이지 입니다. </h1>
	<form name="cartForm" method="post" id="cartForm">
	<table>
		<tr>
			<th>카트번호</th>
			<th>회원이름</th>
			<th>상품이름</th>
			<th>상품컬러</th>
			<th>상품사이즈</th>
			<th>상품금액</th>
			<th>상품수량</th>
			<th>총액</th>
			<th>수정하기</th>
			<th>삭제하기</th>
		</tr>
		
		 <c:choose>
   		 <c:when test="${empty list}">
	   <tr>
        <td colspan="10">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
   		 </tr>
   		 </c:when>
   		 <c:otherwise>
		<c:forEach var="cart" items="${list}">
		<tr>
			<td>${cart.cartNo}</td>
			<td>${cart.userDTO.userName}</td>
			<td>${cart.productDTO.productName}</td>
			<td>${cart.productDTO.productColor}</td>
			<td>${cart.productDTO.productSize}</td>
			<td>${cart.productDTO.productPrice}</td>
			<td>${cart.cartQty}</td>
			<td>${cart.cartQty}*${cart.productDTO.productPrice}</td>
			<td><a href='${servlet}cart&command=update&cartNo=${cart.cartNo}&cartQty=${cart.cartQty}'>수정하기</a></td>
			<td><a href='${servlet}cart&command=delete&cartNo=${cart.cartNo}&userNo=${cart.userDTO.userNo}'>삭제하기</a></td>
		</tr>
		</c:forEach>
		</c:otherwise>
		 </c:choose> 
		
	</table>
	</form>
<jsp:include page="../view/footer.jsp"/>
</body>
</html>