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
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

$(function(){
	$("img").click(function(){
		var no = $(this).parent().prev().text();
		var name = $(this).parent().next().text();
		var addr = "${pageContext.request.contextPath}/servlet?controller=review&command=selectUser&pageNo=1&productNo="+eval(no)+"&productName="+name;

		location.href = addr;
		
	});
});
</script>
      	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<meta name="viewport" content="width=device-width,initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900|Noto+Sans+KR:100,300,400,500,700,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

<jsp:include page="top.jsp"/>
<!--우먼-->     
        <div class="women">
                <a href="./list.html" class="main_menu__title-left">NEW LIST TOP4</a>
 
            <div class="main__list__container">
            <c:forEach items="${listLastest}" var="lastest">
                <div class="main__list">
                	<div> ${lastest.productNo} </div>
                    <div><img alt="이미지입니다." src="${imgPath}${lastest.productName}_L_1.jpg"/>
                    </div>
                    <div>${lastest.productName}</div>
                    <div href="./detail.html" class="info__icon__new" style="display: noen; border: none;"></div>
                    <div href="./detail.html" class="info__price">${lastest.productPrice} WON</div>
                </div>
            </c:forEach>
            </div>
            <a href="./list.html" class="readmore_kr">제품보러가기</a>
        </div>



<%-- <table>
<tr>
<c:forEach items="${listLastest}" var="lastest">
        <td>${lastest.productNo} </td>
        </c:forEach>
        </tr><tr>
        <c:forEach items="${listLastest}" var="lastest">
        <td><img alt="이미지입니다." src="${imgPath}${lastest.productName}_L_1.jpg"/></td>
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
</table> --%>

        <div class="women">
                <a href="./list.html" class="main_menu__title-left">POPULAR LIST TOP4</a>
 
            <div class="main__list__container">
            <c:forEach items="${listPopular}" var="popular">
                <div class="main__list">
                	<div> ${popular.productNo} </div>
                    <div><img alt="이미지입니다." src="${imgPath}${popular.productName}_L_1.jpg"/>
                    </div>
                    <div>${popular.productName}</div>
                    <div href="./detail.html" class="info__icon__new" style="display: noen; border: none;"></div>
                    <div href="./detail.html" class="info__price">${popular.productPrice} WON</div>
                </div>
                
            </c:forEach>
            </div>
            <a href="./list.html" class="readmore_kr">제품보러가기</a>
        </div>
        
<%-- <table>    
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
</table> --%>


<%@ include file="footer.jsp" %>

</body>
</html>