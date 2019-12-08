<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../../view/top.jsp"/>
<h1 align="center">결제 성공 하셨습니다.</h1>
<a href="${pageContext.request.contextPath}/servlet?controller=product+review&command=productList">메인화면으로 가기</a>
<jsp:include page="../../view/footer.jsp"/>
</body>
</html>