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

   
    <div name="OrderManagement">
<h1 class="table--title">주문 관리 </h1>
<form method='post' action="">
<table class="table">
      <tr>
         <th>orderNo</th>
         <th>userNo</th>
         <th>userName</th>
         <th>productNo</th>
         <th>상태</th>
         <th>기능</th>

      </tr>
      <%-- <c:forEach var="list" items="${list}">
         <tr>
            <td>${qna.qnaNo}</td>
            <td><a href="#" class=openMask>${qna.userNo}</a></td>
            <td>${qna.qnaTitle}</td>
            <td>${qna.qnaContent}</td>
            <td><input type="button" value="수정하기"><input type="button" value= "삭제하기"></td>
            </tr>
      </c:forEach> --%>
      <tr>
            <td>orderNo</td>
            <td><a href="#" class=openMask>userNo</a></td>
            <td>userName</td>
            <td>productNo</td>
            <td>주문완료</td>
            <td><input type="submit" value="배송하기"></td>
            </tr>
   </table>
   </form>
   </div>
 
</body>
</html>