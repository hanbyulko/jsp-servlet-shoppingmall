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

<%-- <table><tr>
<c:forEach items="${list}" var="product">
        <td>${product.productNo} </td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${list}" var="product">
        <td><img alt="이미지입니다." src="${imgPath}${product.productName}_L_1.jpg" /></td>
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
</table> --%>

<%-- <c:forEach items="${list}" var="product">
		
        <a href="servlet?command=product&productNo=${product.productNo}">${product.productImg}</a> <br/>
        ${product.productName} <br/>
        ${product.productPrice} <br/>
</c:forEach> --%>
    
<jsp:include page="../view/footer.jsp"/>
</body>
</html>