<%--
  Created by IntelliJ IDEA.
  User: 전환희
  Date: 2019-12-03
  Time: 오후 4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>product history</title>
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
<form name="historyForm" method="post" id="historyForm">
    <table>
        <tr>
            <th>주문번호</th>
            <th>주문일</th>
            <th>상품번호</th>
            <th>상품이름</th>
            <th>상품컬러</th>
            <th>상품사이즈</th>
            <th>상품가격</th>
            <th>주문수량</th>
            <th>주문상태</th>
            <th>리뷰등록</th>
        </tr>

        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <td colspan="20">
                        <p align="center"><b><span style="font-size: 9pt">구매할 상품 없습니다</span></b></p>
                    </td>
                </tr>

            </c:when>
            <c:otherwise>
                <c:forEach var="his" items="${list}">
                    <tr>
                        <td>${his.orderNo}</td>
                        <td>${his.purchaseDate}</td>

                        <td>${his.productDTO.productNo}</td>
                        <td>${his.productDTO.productName}</td>
                        <td>${his.productDTO.productColor}</td>
                        <td>${his.productDTO.productSize}</td>
                        <td>${his.productDTO.productPrice}</td>
                        <td>${his.purchaseQty}</td>
                        <td>${his.purchaseStatus}</td>
                        <td><a href="${pageContext.request.contextPath}/review/review.jsp">리뷰등록</a></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</form>
<jsp:include page="../../view/footer.jsp"/>
</body>
</html>
