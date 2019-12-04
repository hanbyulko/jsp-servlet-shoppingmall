<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{width:200px; height:350px}
	table td{text-align:center;}
</style>
<script type="text/javascript">
function pageMove(){
	location.href='<%=application.getContextPath()%>/servlet?controller=review&command=select';
}
</script>
</head>
<body>
<jsp:include page="../view/top.jsp"/>
<h1 align="center">제품 리스트 페이지 입니다. </h1>

<table><tr>
<c:forEach items="${list}" var="product">
        <td>${product.productNo} </td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${list}" var="product">
        <td><img alt="이미지입니다." src="${imgPath}${product.productName}_L_1.jpg" onclick="pageMove()"/></td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${list}" var="product">
        <td>${product.productName} </td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${list}" var="product">
        <td>${product.productPrice} </td>
     </c:forEach>
     </tr>
</table>

<%-- <c:forEach items="${list}" var="product">
		
        <a href="servlet?command=product&productNo=${product.productNo}">${product.productImg}</a> <br/>
        ${product.productName} <br/>
        ${product.productPrice} <br/>
</c:forEach> --%>
    
<jsp:include page="../view/footer.jsp"/>
</body>
</html>