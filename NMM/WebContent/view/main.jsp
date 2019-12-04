<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NMM</title>
<style>
	img{width:200px; height:350px}
	table td{text-align:center;}
</style>
<script type="text/javascript">
function pageMove(){
	location.href='<%=application.getContextPath()%>/servlet?controller=review&command=select';
}
</script>
<script src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
</script>
      	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<meta name="viewport" content="width=device-width,initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900|Noto+Sans+KR:100,300,400,500,700,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
`
<jsp:include page="top.jsp"/>

<h1 align="center"> 최신상품 LIST TOP4 </h1>
<table>
<tr>
<c:forEach items="${listLastest}" var="lastest">
        <td>${lastest.productNo} </td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${listLastest}" var="lastest">
        <td><img alt="이미지입니다." src="${imgPath}${lastest.productName}_L_1.jpg" onclick="pageMove()"/></td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${listLastest}" var="lastest">
        <td>${lastest.productName} </td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${listLastest}" var="lastest">
        <td>${lastest.productPrice} </td>
     </c:forEach>
     </tr>
</table>
<h1 align="center"> 인기상품 LIST TOP4 </h1>
<table>    
<tr>
<c:forEach items="${listPopular}" var="popular">
        <td>${popular.productNo} </td>
        </c:forEach>
        </tr> <tr>
        <c:forEach items="${listPopular}" var="popular">
        <td><img alt="이미지입니다." src="${imgPath}${popular.productName}_L_1.jpg" onclick="pageMove()"/></td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${listPopular}" var="popular">
        <td>${popular.productName} </td>
        </c:forEach> 
        </tr><tr>
        <c:forEach items="${listPopular}" var="popular">
        <td>${popular.productPrice} </td>
</c:forEach> 
</tr>
</table>


<%@ include file="footer.jsp" %>

</body>
</html>