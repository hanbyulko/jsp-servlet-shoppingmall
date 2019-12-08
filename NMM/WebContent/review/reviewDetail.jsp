<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
</head>
<body class="best">
<h1 class="table--title">Review </h1>
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
            <td><a href="#">${list.reviewTitle}</a></td>
            <td>${list.reviewContent}</td>
            <td>${list.reviewStar}</td>
            <td>${list.reviewDate}</td>
      </c:forEach>
   </table>
   <!-- 페이징처리 -->
	<nav class="pagination-container">
		<div class="pagination">
			<a class="pagination-newer"
				href="${servlet}review&command=${command}&keyword=${keyword}&category=${category}&pageNo=${pageNo>1?pageNo-1:1}&productNo=${productNo}">PREV</a>
			<span class="pagination-inner"> <c:forEach var='i' begin='1'
					end='${pageCnt}'>
					<a class="${i==pageNo?'pagination-active':page}"
						href="${servlet}review&command=${command}&category=${category}&keyword=${keyword}&pageNo=${i}&productNo=${productNo}">${i}</a>
				</c:forEach>
			</span> <a class="pagination-older"
				href="${servlet}review&command=${command}&keyword=${keyword}&category=${category}&pageNo=${pageNo<pageCnt?pageNo+1:pageCnt}&productNo=${productNo}">NEXT</a>
		</div>
	</nav>
   	
</body>
</html>