<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>product purchase</title>
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
<jsp:include page="../../view/top.jsp"/>
<h1>product history</h1>
<form name="purchaseForm" method="post" id="purchaseForm">
    <table>
        <tr>
            <h2>배송정보</h2>
            <th>주문자</th>
            <th>번호</th>
            <th>이메일</th>
            <th>배송지</th>

        </tr>

        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="20">
                        <p align="center"><b><span style="font-size: 9pt">배송정보가 없습니다</span></b></p>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="pur" items="${list}">
                    <tr>
                        <td>${pur.userDTO.userName}</td>
                        <td>${pur.userDTO.userPhone}</td>
                        <td>${pur.userDTO.userEmail}</td>
                        <td>${pur.userDTO.userAddr}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
    <table>
        <tr>
            <h2>주문상품 정보</h2>
            <th>상품이름</th>
            <th>수량</th>
            <th>색</th>
            <th>사이즈</th>
            <th>가격</th>

        </tr>

        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="20">
                        <p align="center"><b><span style="font-size: 9pt">주문상품 정보가 없습니다</span></b></p>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="pur" items="${list}">
                    <tr>
                        <td>${pur.productDTO.productName}</td>
                        <td>${pur.productDTO.productStock}</td>
                        <td>${pur.productDTO.productColor}</td>
                        <td>${pur.productDTO.productSize}</td>
                        <td>${pur.productDTO.productPrice}</td>

                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
    <a href="${servlet}purchase&command=payment" >결제하기</a><br>

</form>

<jsp:include page="../../view/footer.jsp"/>
</body>
</html>
