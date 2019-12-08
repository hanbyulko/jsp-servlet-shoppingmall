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
            <c:when test="${empty userDTO}">
                <tr>
                    <td colspan="20">
                        <p align="center"><b><span style="font-size: 9pt">배송정보가 없습니다</span></b></p>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                    <tr>
                        <td>${userDTO.userName}</td>
                        <td>${userDTO.userPhone}</td>
                        <td>${userDTO.userEmail}</td>
                        <td>${userDTO.userAddr}</td>
                    </tr>
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
            <c:when test="${empty productDTO}">
                <tr>
                    <td colspan="20">
                        <p align="center"><b><span style="font-size: 9pt">주문상품 정보가 없습니다</span></b></p>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                    <tr>
                        <td>${productDTO.productName}</td>
                        <td>${cartQty}</td>
                        <td>${productDTO.productColor}</td>
                        <td>${productDTO.productSize}</td>
                        <td>${productDTO.productPrice*cartQty}</td>

                    </tr>
            </c:otherwise>
        </c:choose>
    </table>
    <a href="${pageContext.request.contextPath}/user/purchase/api.jsp?name=${userDTO.userName}&email=${userDTO.userEmail}&phone=${userDTO.userPhone}&address=${userDTO.userAddr}&productName=${productDTO.productName}" >결제하기</a><br>
</form>

<jsp:include page="../../view/footer.jsp"/>
</body>
</html>
