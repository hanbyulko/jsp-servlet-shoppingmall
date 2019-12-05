<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js"></script>
<style>

.form-btn{
    display: block;
    width: 70px;
    font-size: 13px;
    height: 40px;
    background-color: #000;
    color: #fff;
    box-sizing: border-box;
    margin: 5px 0;
    cursor: pointer;
}
</style>
</head>
<body>
<h1>purchaseHistory.jsp</h1>
<%-- <c:if test="${purchse.review==null}"> --%>
<input type ="button" value = "리뷰등록" class="form-btn" onclick="location.href='<%=application.getContextPath()%>/review/review.jsp'">
<%-- <c:otherwise> --%>
<input type ="button" value = "리뷰수정" class="form-btn"  onclick="location.href='<%=application.getContextPath()%>/review/reviewUpdate.jsp'">
<%-- </c:otherwise>
</c:if> --%>
   
</body>
</html>