<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr><jsp:include page="../view/top.jsp"/>
<jsp:include page="leftButton.jsp"/>


	<!-- 파일을 전송하기 위한 enctype -->

	<form name="productFrm" action="${servlet}product&command=insert" enctype="multipart/form-data" method="post">

		<table style="width: 80%">
			<tr>
				<th colspan="2">** 상품 등록 **</th>
			</tr>
			<tr>
				<td style="width:20%">상품명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>종류</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>색상</td>
				<td><input type="text" name="color"></td>
			</tr>
			<tr>
				<td>사이즈</td>
				<td><input type="text" name="size"></td>
			</tr>
			<tr>
				<td>재고량</td>
				<td><input type="text" name="stock"></td>
			</tr>
			<tr>
				<td>대표 이미지</td>
				<td>
					<img name="preview" src="../images/product/noimage.jpg" style="width:100%"><br/>
					<input type="file" name="L_1" size="30" onchange="filePreview()">
				</td>
				<td>상품 상세 이미지</td>
				<td>
					<img name="preview" src="../images/product/noimage.jpg" style="width:100%"><br/>
					<input type="file" name="D_1" size="30" onchange="filePreview()">
				</td>
				<td>상품 확대 이미지</td>
				<td>
					<img name="preview" src="../images/product/noimage.jpg" style="width:100%"><br/>
					<input type="file" name="D_2" size="30" onchange="filePreview()">
				</td>
			</tr>
			<tr>
				<td colspan="2"><br /> <input type="submit" value="상품 등록">
					<input type="reset" value="새로 입력" onclick="resetInsertData()">
				</td>
			</tr>
		</table>
	</form>


<jsp:include page="../view/footer.jsp"/>

</body>
</html>