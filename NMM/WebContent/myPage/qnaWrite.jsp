<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<h2 class="table--title">문의하기</h2>
	<hr>
	<form action='${servlet}qna&command=insert' method='post'>
		<div class="form-group row">
			<label for="inputEmail3" class="col-sm-2 col-form-label">상품번호</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name='productNoqnaTitle'
					placeholder="클릭시 검색창이 팝업됩니다." onclick='popUp()'>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputEmail3" class="col-sm-2 col-form-label">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name='productNoqnaTitle'
					placeholder="문의 제목을 입력해주세요">
			</div>
		</div>
		<div class="form-group row">
			<label for="inputPassword3" class="col-sm-2 col-form-label">내용</label>
			<div class="col-sm-10">
				<textarea class="form-control" name='qnaContent' rows="5"
					placeholder='불편사항을 상세하게 기재해주세요.'></textarea>
			</div>
		</div>
		<fieldset class="form-group">
			<div class="row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">구분</label>
				<div class="col-sm-10">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gridRadios"
							id="gridRadios1" value="option1" checked> <label
							class="form-check-label" for="gridRadios1"> 상품 문의 </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gridRadios"
							id="gridRadios2" value="option2"> <label
							class="form-check-label" for="gridRadios2"> 반품 문의 </label>
					</div>
						<input class="form-check-input" type="radio" name="gridRadios"
							id="gridRadios3" value="option3" > <label
							class="form-check-label" for="gridRadios3"> 배송 문의 </label>
				</div>
			</div>
		</fieldset>
		<div class="form-group row">
			<label for="inputEmail3" class="col-sm-2 col-form-label">답변알림</label>
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck1">
					<label class="form-check-label" for="gridCheck1"> 내 이메일로 답변
						알림 받기 </label>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
			<button type="submit" class="form-btn cart" id="cart">제출하기</button>
			</div>
		</div>
	</form>
</body>
</html>