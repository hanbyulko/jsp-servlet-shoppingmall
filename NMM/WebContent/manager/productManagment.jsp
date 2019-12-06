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
<div name="productManagement">
<h1 class="table--title">상품 관리 </h1>
<form method='post' action="<%=application.getContextPath()%>/manager/productManagementUpdate.jsp">
<table class="table">
      <tr>
         <th>상품 번호</th>
         <th>상품 이름</th>
         <th>상품 가격</th>
         <th>재고</th>
         <th>기능</th>

      </tr>
      <%-- <c:forEach var="list" items="${list}">
         <tr>
            <td>${product.productNo}</td>
            <td><a href="#" class=openMask>${product.productName}</a></td>
            <td>${list.productPrice}</td>
            <td>${list.productStock}</td>
            <td><input type="button">수정하기<input type="button">삭제하기</td>
            </tr>
      </c:forEach> --%>
      <tr>
            <td>productNo</td>
            <td><a href="#" class=openMask>productName</a></td>
            <td>productPrice</td>
            <td>productStock</td>
            <td><input type="submit" value="수정하기"><input type="button" value= "삭제하기"></td>
            </tr>
   </table>
   </form>
   
   </div>
   
   
 
</body>
</html>