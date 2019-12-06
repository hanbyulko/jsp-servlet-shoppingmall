<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
      	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<meta name="viewport" content="width=device-width,initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900|Noto+Sans+KR:100,300,400,500,700,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
	table,tr,th,td{	border: solid 1px black;}
	.display-none{display: none;}
	.buyList form table th{width:100px;}
	#buyList--productName{width:300px; background-color: maroon;}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

////////업데이트
	 $(document).on("click", "#update" ,function(){
		var cartQty = $(this).parent().prev().prev().find("input:first").val();
		var cartNo = $(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text();
		var productNo = $(this).parent().prev().prev().prev().prev().prev().prev().prev().text();
		alert(11);
		alert(cartNo);
		alert(cartQty);
		$.ajax({
			  type:"post",
			  url:"cartUpdateServlet",
		      dataType: "text",//서버에게 받은 응답결과 type(text, xml, html, json)
		     data : {"cartQty":cartQty,"cartNo":cartNo} ,//서버에게 전송할 parameter
		      success: function(result){
		    	  alert(result);
				if(result>0){
					alert("수정성공");
					location.reload();
				}else{
					alert("수정실패");
				}
		      } ,
		      error : function(err){
		    	  console.log(err+"=> 오류발생");
		      }
		  	});//ajax끝
	});//update끝 
	
///////delete시작	
	$(document).on("click", "#delete" ,function(){
		var cartNo = $(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text();
		alert(cartNo);
			alert('삭제');
		$.ajax({
			  type:"post",
			  url:"cartDeleteServlet",
		      dataType: "text",//서버에게 받은 응답결과 type(text, xml, html, json)
		      data : {"cartNo" :cartNo} ,//서버에게 전송할 parameter
		      success: function(result){
				if(result>0){
					alert("삭제ㄱㄱ성공");
					location.reload();
				}else{
					alert("삭제ㄱㄱ실패");
				}
		      } ,
		      error : function(err){
		    	  console.log(err+"=> ㄱㄱ오류발생");
		      }
		  	});//ajax끝
		
	});//delete끝
	
	//구매버튼 누르면
	$(document).on("click", "[name=buyForm]" ,function(){
			var length = $("input:checkbox:checked").length;
			var checkBox = $("input:checkbox:checked");
			var cartNo;
			var productNo;
			var productName;
			var productColor;
			var productSize;
			var productPrice;
			var cartQty;
			var totalPrice;
			var str;
			//체크된 체크박스의 값을 반복해 불러옴
			checkBox.each(function (length){
				cartNo = ($(this).parent().prev().text());
				productNo = ($(this).parent().next().text());
				productName = ($(this).parent().next().next().text());
				productColor = ($(this).parent().next().next().next().text());
				productSize = ($(this).parent().next().next().next().next().text());
				productPrice = ($(this).parent().next().next().next().next().next().text());
				cartQty = ($(this).parent().next().next().next().next().next().next().find("input:first").val());
				totalPrice = ($(this).parent().next().next().next().next().next().next().next().text());
				
				str+="<tr>";
				str+="<td class='display-none'>"+cartNo+"</td>";
				str+="<td class='display-none'>"+productNo+"</td>";
				str+="<td>"+productName+"</td>";
				str+="<td>"+productColor+"</td>";
				str+="<td>"+productSize+"</td>";
				str+="<td>"+productPrice+"</td>";
				str+="<td>"+cartQty+"</td>";
				str+="<td>"+totalPrice+"</td>";
				str+="</tr>";
				
				str+="<input type='hidden' name='pno' value=''>"
					str+="<input type='hidden' name='qty' value=''>"
			}); 
			str+="</table>";
			
			$("#buyList-form-first-tr").after(str);
	});//buyList 끝
	
	
</script>

</head>
<body>
<jsp:include page="../view/top.jsp"/>
<h1>CART페이지 입니다. </h1>

	<form name="cartForm" method="post" id="cartForm" action='${servlet}cart&command=update' 
	onsubmit='return updateSubmit()'>
	<table>
		<tr>
			<th>카트번호</th>
			<th>상품선택하자</th>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>상품컬러</th>
			<th>상품사이즈</th>
			<th>상품금액</th>
			<th>상품수량</th>
			<th>총액</th>
			<th>수정하기</th>
			<th>삭제하기</th>
		</tr>
		
		 <c:choose>
   		 <c:when test="${empty list}">
	   <tr>
        <td colspan="10">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
   		 </tr>
   		 </c:when>
   		 <c:otherwise>
		<c:forEach var="cart" items="${list}">
		<tr>
			<td>${cart.cartNo}</td>
			<td><input type="checkbox"></td>
			<td>${cart.productDTO.productNo}</td>
			<td>${cart.productDTO.productName}</td>
			<td>${cart.productDTO.productColor}</td>
			<td>${cart.productDTO.productSize}</td>
			<td>${cart.productDTO.productPrice}</td>
			<td><input type="number" value=${cart.cartQty} name="cartQty" id="qty" class="input-number"></td>
			<td>${cart.cartQty*cart.productDTO.productPrice}</td>
			<td><input type="button" value="수정하기" id="update" ></td>
			<td><input type="button" value="삭제하기" id="delete"></td>
			</tr>
		</c:forEach>
		</c:otherwise>
		 </c:choose> 
		
	</table>
	</form>
	
	<div>
		<form  method="post" id="buyForm">
		<input type="button" name="buyForm" value="구매하기" style="padding:30px">
		</form>
	</div>	


<div class="buyList">
	<h1>구매목록 페이지 </h1>
	<div>
		<form method="post" id="buyList-form" action='${servlet}purchase&command=insertPurchaseDB'>
		<table>
			<tr id="buyList-form-first-tr">
				<th class="display-none">카트번호</th>
				<th class="display-none">상품번호</th>
				<th id="buyList--productName">상품이름</th>
				<th>상품컬러</th>
				<th>상품사이즈</th>
				<th>상품금액</th>
				<th>상품수량</th>
				<th>총액</th>
			</tr>
		</table>
		</form>
	</div>
	
	<div>
		<form  method="post" >
		<input type="submit" id="purchaseBtn"  value="결제하기" style="padding:30px">
		</form>
	</div>	

</div>


<jsp:include page="../view/footer.jsp"/>
</body>

</html>