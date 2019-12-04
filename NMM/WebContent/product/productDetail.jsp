<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{width:500px; height:700px;}
</style>
<script type="text/javascript">
function plus(){
	var value = document.getElementById("quantity").value
	
}
function minus(){
	var value = document.getElementById("quantity").value = eval(document.getElementById("quantity").value-1);
	if(document.getElementById("quantity").value==0){
		document.getElementById("quantity").value=0;
	}
}
</script>
</head>
<body>
<jsp:include page="../view/top.jsp"/>
<h1> 제품상세페이지입니다. </h1>
<table>
<tr><td rowspan="50"><img alt="이미지입니다." src="/NeverMineMall/images/DENIM LAYERED LEATHER JACKET_awa225w(BLACK)_D_1.jpg"></td><td>상품이름 : </td><tr>
<tr><td>PRICE :  WON</td><tr>
<tr><td>COLOR : </td><tr>
<tr><td>SIZE : </td><tr>
<tr><td>QUANTITY : <BUTTON TYPE="BUTTON" onclick="minus()">-</BUTTON><input type="text" value=1 size="2" id="quantity"></input><BUTTON TYPE="BUTTON" onclick="plus()">+</BUTTON></td><tr>
<tr><td>TOTAL :  WON</td><tr>
<tr><td><button type="button" value="">구매하기</button></td><tr>
<tr><td><button type="button" value="">장바구니</button></td><tr>
</table>
<jsp:include page="../review/reviewDetail.jsp" />
<jsp:include page="../view/footer.jsp"/>
</body>
</html>