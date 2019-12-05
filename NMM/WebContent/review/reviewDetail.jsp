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
<h1 class="table--title">상품 리뷰 </h1>
<table class="table">
      <tr>
         <th>리뷰 번호</th>
         <th>제목</th>
         <th>내용</th>
         <th>별점</th>
         <th>날짜</th>

      </tr>
      <c:forEach var="list" items="${list}">
         <tr>
            <td>${list.reviewNo}</td>
            <td><a href="#" class=openMask>${list.reviewTitle}</a></td>
            <td>${list.reviewContent}</td>
            <td>${list.reviewStar}</td>
            <td>${list.reviewDate}</td>
      </c:forEach>
   </table>
</body>
</html>