<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js"></script>

</head>
<body>
<h1>purchaseHistory.jsp</h1>
<%-- <c:if test="${purchse.review==null}"> --%>
<input type ="button" value = "리뷰등록" onclick="location.href='<%=application.getContextPath()%>/myPage/review.jsp'">
<%-- <c:otherwise> --%>
<input type ="button" value = "리뷰수정" onclick="location.href='<%=application.getContextPath()%>/myPage/reviewUpdate.jsp'">
<%-- </c:otherwise>
</c:if> --%>
   
</body>
</html>