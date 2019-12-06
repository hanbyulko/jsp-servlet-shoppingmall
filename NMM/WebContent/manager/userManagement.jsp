<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script> 
      setTimeout(function(){
         location.reload();
      }, 10000);

</script> -->
</head>
<style>
body,html{
    height: 100%;
    background-color: #f4f4f4;
    font-family: 'Maven Pro','Noto Sans KR';
}
th{
    text-align: center;
}
.table{
    height: auto;
    display:table;
    margin: 0 auto;
    text-align: center;
}
.table--title{
    width: 100%;
    text-align: center;
    font-size: 50px;
}
</style>
<body>
   
   <div name="userManagement">
<h1 class="table--title">회원 관리 </h1>
<form method='post' action="<%=application.getContextPath()%>/manager/userManagementUpdate.jsp">
<table class="table">
      <tr>
         <th>회원 번호</th>
         <th>회원 ID</th>
         <th>회원 이름</th>
         <th>회원 비밀번호</th>
         <th>기능</th>

      </tr>
      <%-- <c:forEach var="list" items="${list}">
         <tr>
            <td>${userDB.userNo}</td>
            <td><a href="#" class=openMask>${userDB.userID}</a></td>
            <td>${userDB.userName}</td>
            <td>${userDB.userPassword}</td>
            <td><input type="button">수정하기<input type="button">삭제하기</td>
            </tr>
      </c:forEach> --%>
      <tr>
            <td>userNo</td>
            <td><a href="#" class=openMask>userID</a></td>
            <td>userName</td>
            <td>userPassword</td>
            <td><input type="submit" value="수정하기"><input type="button" value= "삭제하기"></td>
            </tr>
   </table>
    </form>
   </div>
   
</body>
</html>