<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
관리자 유저관리 페이지입니다
<jsp:include page="leftButton.jsp"/>
관리자유저 CRUD작업을 할 수 있습니다.<p>
		<c:forEach var="managerUserDTO" items="${list}">
		관리자명 ${managerUserDTO.mgtUserNo} 
		관리자 아이디 ${managerUserDTO.mgtUserId} 
		관리자 비밀번호 ${managerUserDTO.mgtUserPwd} <p>
		</c:forEach>
</body>
</html>