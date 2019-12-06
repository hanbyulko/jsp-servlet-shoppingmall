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

   
   <div name="FAQManagement">
<h1 class="table--title">FAQ 관리 </h1>
<form method='post' action="<%=application.getContextPath()%>/manager/FAQManagementUpdate.jsp">
<table class="table">
      <tr>
         <th>QNA 번호</th>
         <th>회원 번호</th>
         <th>QnA 제목</th>
         <th>QnA 내용</th>
         <th>상태</th>
         <th>기능</th>

      </tr>
      <%-- <c:forEach var="list" items="${list}">
         <tr>
            <td>${qna.qnaNo}</td>
            <td><a href="#" class=openMask>${qna.userNo}</a></td>
            <td>${qna.qnaTitle}</td>
            <td>${qna.qnaContent}</td>
            <td><input type="button" value="답변달기"></td>
            </tr>
      </c:forEach> --%>
      <tr>
            <td>qnaNo</td>
            <td><a href="#" class=openMask>userNo</a></td>
            <td>qnaTitle</td>
            <td>qnaContent</td>
            <td>답변완료</td>
            <td><input type="submit" value="답변달기"></td>
            </tr>
   </table>
   </form>
   </div>
   

 
</body>
</html>