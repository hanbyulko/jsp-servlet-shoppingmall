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
<form method='post' action="${servlet}review&command=update" >
<div>
   <h3>만족도 평가</h3></p>
   <strong>상품에 만족하셨나요 ?</strong><p>
   <c:choose>
   <c:when test="${list.reviewStar}==1}">
   <input type="radio" name="reviewStar" checked="checked"><strong>*</strong>
   <input type="radio" name="reviewStar" ><strong>**</strong>
   <input type="radio" name="reviewStar" ><strong>***</strong>
   <input type="radio" name="reviewStar" ><strong>****</strong>
   <input type="radio" name="reviewStar" ><strong>*****</strong>
   </c:when>
   <c:when test="${list.reviewStar}==2}">
   <input type="radio" name="reviewStar" ><strong>*</strong>
   <input type="radio" name="reviewStar" checked="checked"><strong>**</strong>
   <input type="radio" name="reviewStar" ><strong>***</strong>
   <input type="radio" name="reviewStar" ><strong>****</strong>
   <input type="radio" name="reviewStar" ><strong>*****</strong>
   </c:when>
   <c:when test="${list.reviewStar}==3}">
   <input type="radio" name="reviewStar" ><strong>*</strong>
   <input type="radio" name="reviewStar" ><strong>**</strong>
   <input type="radio" name="reviewStar" checked="checked"><strong>***</strong>
   <input type="radio" name="reviewStar" ><strong>****</strong>
   <input type="radio" name="reviewStar" ><strong>*****</strong>
   </c:when>
   <c:when test="${list.reviewStar}==4}">
   <input type="radio" name="reviewStar" ><strong>*</strong>
   <input type="radio" name="reviewStar" ><strong>**</strong>
   <input type="radio" name="reviewStar" ><strong>***</strong>
   <input type="radio" name="reviewStar" checked="checked"><strong>****</strong>
   <input type="radio" name="reviewStar" ><strong>*****</strong>
   </c:when>
   <c:otherwise>
   <input type="radio" name="reviewStar" ><strong>*</strong>
   <input type="radio" name="reviewStar" ><strong>**</strong>
   <input type="radio" name="reviewStar" ><strong>***</strong>
   <input type="radio" name="reviewStar" ><strong>****</strong>
   <input type="radio" name="reviewStar" checked="checked"><strong>*****</strong>
   </c:otherwise>
</c:choose>
   
</div>
<div>
<h3>상품리뷰작성</h3>
리뷰 제목 : <input type = "text" id="reviewTitle" name='reviewTitle' style="text-align:left; width:200px; height:20px;">${list.reviewTitle}<p>
리뷰 내용 : <input type="text" id="reviewContent" name="reviewContent" style="text-align:left; width:400px; height:400px;">${list.reviewContent}<p>
<input type="submit" name = "insert" value="수정">

</form>

</div>

</body>
</html>