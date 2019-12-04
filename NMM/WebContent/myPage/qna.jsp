<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mask {
	position: absolute;
	z-index: 9000;
	background-color: #000;
	display: none;
	left: 0;
	top: 0;
}
.window {
	display: none;
	position: absolute;
	left: 50%;
	top: 50px;
	margin-left: -500px;
	width: 1000px;
	height: 500px;
	background-color: #FFF;
	z-index: 10000;
}
</style>
</head>
<body>
	<jsp:include page="../view/top.jsp"></jsp:include>
	<p>
		1대1문의 게시판입니다 <br> <br>
	<p>
	<table>
		<tr>
			<th>게시글번호</th>
			<th>상품번호</th>
			<th>제목</th>
			<th>작성날짜</th>
			<th>답변상태</th>
			<th>삭제하기</th>
		</tr>
		<c:forEach var="qnaDTO" items="${list}">
			<tr>
				<td>${qnaDTO.qnaNo}</td>
				<td><a href="#" class=openMask>${qnaDTO.productDTO.productName}</a></td>
				<td>${qnaDTO.qnaTitle}</td>
				<td>${qnaDTO.qnaDate}</td>
				<td>${qnaDTO.qnaResponseState}</td>
				<td><a
					href='${servlet}qna&command=delete&qnaNo=${qnaDTO.qnaNo}'>삭제하기</a></td>
		</c:forEach>
	</table>
	<p>
		<br> <br>
	<form method='post' action='${servlet}qna&command=insert'>
		상품명 <input type="text" name='productNo'></input>
		<p>
			제목 <input type="text" name='qnaTitle'></input>
		<p>
			내용 <input type="text" name='qnaContent'></input>
		<p>
			<input type="submit" />
	</form>

	<div id="wrap">
		<div id="container">
			<div id="mask"></div>
			<div class="window">
				<p id=title
					style="width: 1000px; height: 500px; text-align: center; vertical-align: middle;">
					질문 제목 <br> 질문 내용 <br> 답변 내용
				</p>
				<div></div>

				<p style="text-align: center; background: #ffffff; padding: 20px;">
					<a href="#" class="close">창 닫기</a>
				</p>
			</div>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td align="center"><a href="#" class="openMask"></a></td>
				</tr>
			</table>
		</div>
	</div>


	<input type="hidden" id="qt" value="${qnaTitle}">
	<input type="hidden" id="qc" value="${qnaContent}">
	<input type="hidden" id="qrc" value="${qnaResponseContent}">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		function wrapWindowByMask() {

			var maskHeight = $(document).height();
			var maskWidth = $(window).width();

			$("#mask").css({
				"width" : maskWidth,
				"height" : maskHeight
			});

			$("#mask").fadeIn(0);
			$("#mask").fadeTo("slow", 0.6);

			$(".window").show();
			$window.opener.document.getElementById("#content").value = $("#qc")
					.val()
		}

		$(document).ready(function() {
			$(".openMask").click(function(e) {
				e.preventDefault();
				wrapWindowByMask();
			});
			$(".window .close").click(function(e) {
				e.preventDefault();
				$("#mask, .window").hide();
			});

			$("#mask").click(function() {
				$(this).hide();
				$(".window").hide();

			});

		});
	</script>

	<jsp:include page="../view/footer.jsp"></jsp:include>
</body>
</html>