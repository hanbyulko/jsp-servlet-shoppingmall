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
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

$(function(){
	$("img").click(function(){
		var no = $(this).parent().prev().text();
		var addr = "${pageContext.request.contextPath}/servlet?controller=review&command=select&productNo="+eval(no);
		
		location.href = addr;
		
	});
});
/* function pageMove(){
	alert("${pageContext.request.contextPath}/servlet?controller=review&command=select");
	location.href='${pageContext.request.contextPath}/servlet?controller=review&command=select&productNo=';
} */
</script>
</head>
<body>
<jsp:include page="../view/top.jsp"/>

<!--우먼-->     
        <div class="women">
                <a href="./list.html" class="main_menu__title-left">PRODUCT LIST</a>
 
            <div class="main__list__container">
            <c:forEach items="${list}" var="product">
                <div class="main__list">
                	<div> ${product.productNo} </div>
                    <div><img alt="이미지입니다." src="${imgPath}${product.productName}_L_1.jpg"/>
                    </div>
                    <div>${product.productName}</div>
                    <div href="./detail.html" class="info__icon__new" style="display: noen; border: none;"></div>
                    <div href="./detail.html" class="info__price">${product.productPrice}</div>
                </div>
            </c:forEach>
            </div>
            <a href="./list.html" class="readmore_kr">제품보러가기</a>
        </div>


<%-- <c:forEach items="${list}" var="product">

@import url("https://fonts.googleapis.com/css?family=Roboto:400,300");

body {
	color: #2c3e50;
	font-family: 'Roboto', sans-serif;
	font-weight: 400;
}

h1 {
	text-align: center;
	font-size: 2.5rem;
	font-weight: 300;
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

img {
	width: 200px;
	height: 350px
}

table td {
	text-align: center;
}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

		
        <a href="servlet?command=product&productNo=${product.productNo}">${product.productImg}</a> <br/>
        ${product.productName} <br/>
        ${product.productPrice} <br/>
</c:forEach> --%>


<%-- <a class="pagination-active" href="servlet?command=searchByCategory&category=${category}&pageNo=${pageNo-1}">1</a>  --%>
	<!-- 페이징처리 -->
	<nav class="pagination-container">
		<div class="pagination">
			<a class="pagination-newer" href="servlet?command=searchByCategory&category=${category}&pageNo=${pageNo-1}">PREV</a> 
				<span class="pagination-inner"> 
				<c:forEach var='i' begin='0' end='${pageCnt}'>
				<a href="servlet?command=searchByCategory&category=${category}&pageNo${i}">${i}</a> 
				</c:forEach>
				</span> 
			<a class="pagination-older" href="servlet?command=searchByCategory&category=${category}&pageNo=${pageno+1}">NEXT</a>
		</div>
	</nav>


	<jsp:include page="../view/footer.jsp" />

</body>
</html>