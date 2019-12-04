<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js"></script>

</head>
<body>
<form method='post' action="${servlet}review&command=insert">
<div>
	<h3>만족도 평가</h3></p>
	<strong>상품에 만족하셨나요 ?</strong><p>
	<input type="radio" name="reviewStar"><strong>*</strong>
	<input type="radio" name="reviewStar"><strong>**</strong>
	<input type="radio" name="reviewStar"><strong>***</strong>
	<input type="radio" name="reviewStar"><strong>****</strong>
	<input type="radio" name="reviewStar"><strong>*****</strong>
</div>
<div>
<h3>상품리뷰작성</h3>
리뷰 제목 : <input type = "text" id="reviewTitle" name='reviewTitle' style="text-align:left; width:200px; height:20px;"><p>
리뷰 내용 : <input type="text" id="reviewContent" name="reviewContent" style="text-align:left; width:400px; height:400px;"><p>
<input type="submit" value="등록" />
<input type = "button" value= "수정" a href='<%=application.getContextPath()%>/servlet?review&command=update'>
</div>
</form>
</body>
</html>