<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
a {text-decoration: none;}
li {list-style: none;}

body,html{
    height: 100%;
    font-family: 'Maven Pro','Noto Sans KR';
}</style>
</head>
<body>
testpage
<jsp:include page="../../review/review.jsp"/>
<jsp:include page="../../review/reviewUpdate.jsp"/>
</body>
</html>