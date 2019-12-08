<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url("https://fonts.googleapis.com/css?family=Roboto:400,300");
body {
   color: #2c3e50;
   font-family: 'Roboto', sans-serif;
   font-weight: 400;
}

h1 {
   text-align: center;
   font-size: 2.5rem;
   font-weight: 300;
}

.pagination-container {
   margin: 100px auto;
   text-align: center;
}

.pagination {
   position: relative;
}

.pagination a {
   position: relative;
   display: inline-block;
   color: #2c3e50;
   text-decoration: none;
   font-size: 1.2rem;
   padding: 8px 16px 10px;
}

.pagination a:before {
   z-index: -1;
   position: absolute;
   height: 100%;
   width: 100%;
   content: "";
   top: 0;
   left: 0;
   background-color: #2c3e50;
   border-radius: 24px;
   -webkit-transform: scale(0);
   transform: scale(0);
   transition: all 0.2s;
}

.pagination a:hover, .pagination a .pagination-active {
   color: #fff;

}

.pagination a:hover:before, .pagination a .pagination-active:before {
   -webkit-transform: scale(1);
   transform: scale(1);
   
}

.pagination .pagination-active {
   color: #fff;
}

.pagination .pagination-active:before {
   -webkit-transform: scale(1);
   transform: scale(1);
}

.pagination-newer {
   margin-right: 50px;
}

.pagination-older {
   margin-left: 50px;
}


body, html {
   height: 100%;
   background-color: #f4f4f4;
   font-family: 'Maven Pro', 'Noto Sans KR';
}

th {
   text-align: center;
}

.table {
   height: auto;
   display: table;
   margin: 0 auto;
   text-align: center;
}

.table--title {
   width: 100%;
   text-align: center;
   font-size: 50px;
}
</style>
</head>
<body>
   <jsp:include page="../view/top.jsp" />
   <h1 class="table--title">상품 관리</h1>
   <table class="table">
      <tr>
         <th>상품번호</th>
         <th>상품 이미지</th>
         <th>상품명</th>
         <th>재고</th>
         <th>가격</th>
         <th>수정</th>
         <th>삭제</th>
      </tr>
      <c:forEach var="productDTO" items="${list}" >
         <tr>
            <td>${productDTO.productNo}</td>
            <td><img src="${imgPath}${productDTO.productName}_L_1.jpg" alt="이미지입니다." style="width:100px; height:100px"/></td>
            <td>${productDTO.productName}</td>
            <td>${productDTO.productStock}</td>
            <td>${productDTO.productPrice}</td>
            <td><button type="button">수정</button></td>
            <td><button type="button">수정</button></td>
         </tr>
      </c:forEach>
   </table>
   
   <!-- 페이징처리 -->
   <nav class="pagination-container">
      <div class="pagination">
         <a class="pagination-newer"
            href="${servlet}qna&command=${command}&keyword=${keyword}&category=${category}&pageNo=${pageNo>1?pageNo-1:1}">PREV</a>
         <span class="pagination-inner"> <c:forEach var='i' begin='1'
               end='${pageCnt}'>
               <a class="${i==pageNo?'pagination-active':page}"
                  href="${servlet}qna&command=${command}&category=${category}&keyword=${keyword}&pageNo=${i}">${i}</a>
            </c:forEach>
         </span> <a class="pagination-older"
            href="${servlet}qna&command=${command}&keyword=${keyword}&category=${category}&pageNo=${pageNo<pageCnt?pageNo+1:pageCnt}">NEXT</a>
      </div>
   </nav>
   
   
<jsp:include page="../view/footer.jsp" />
   
</body>
</html>