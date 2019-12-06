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
   table,tr,th,td{   border: solid 1px black;}
   table{width:1100px;}
   .display-none{display: none;}
   .buyList form table th{width:100px;}
   #buyList--productName{width:500px;}
   
   .show{display: block;}
   .hide{display: none;}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

////////업데이트
    $(document).on("click", "#update" ,function(){
      var cartQty = $(this).parent().prev().prev().find("input:first").val();
      var cartNo = $(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text();
      var productNo = $(this).parent().prev().prev().prev().prev().prev().prev().prev().text();
      
      $.ajax({
           type:"post",
           url:"cartUpdateServlet",
           dataType: "text",//서버에게 받은 응답결과 type(text, xml, html, json)
           data : {"cartQty":cartQty,"cartNo":cartNo} ,//서버에게 전송할 parameter
           success: function(result){
	            if(result>0){
	               alert("수량을 변경하였습니다.");
	               location.reload();
	            }else{
	               alert("수량이 변경되지 않았습니다.");
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
      $.ajax({
           type:"post",
           url:"cartDeleteServlet",
            dataType: "text",//서버에게 받은 응답결과 type(text, xml, html, json)
            data : {"cartNo" :cartNo} ,//서버에게 전송할 parameter
            success: function(result){
	            if(result>0){
	               alert("삭제하였습니다.");
	               location.reload();
	            }else{
	               alert("삭제하지 못했습니다.");
	            }
            } ,
            error : function(err){
               console.log(err+"=> ㄱㄱ오류발생");
            }
           });//ajax끝
      
   });//delete끝
   
   //구매버튼 누르면
   $(document).on("click", "[name=buyBtn]" ,function(){
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
         
         //선택이 있을때 작동
         if(length>0){
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
		            if(!productName==""){
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
		            }
	         }); 
	         str+="</table>";
	         $("#buyList-form-first-tr").after(str);
	         $('.buyList').removeClass("hide");
	         $('.buyList').addClass("show");
	         $('.cartList').removeClass("show");
	         $('.cartList').addClass("hide");
         }else{
        	 alert("구매할 목록을 선택해주세요");
         }
         
   });//buyList 끝
   
   
</script>

</head>
<body>
<jsp:include page="../view/top.jsp"/>

<div class="cartList show">

<h1>CART페이지 입니다. </h1>

   <form name="cartForm" method="post" id="cartForm" action='${servlet}cart&command=update'>
   <table>
      <tr>
         <th class="hide">카트번호</th>
         <th>선택</th>
         <th class="hide">상품번호</th>
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
         <td class="hide">${cart.cartNo}</td>
         <td><input type="checkbox"></td>
         <td class="hide">${cart.productDTO.productNo}</td>
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
      <span>
	      <input type="checkbox" id="allCheck" value="전체선택">전체선택
      </span>
      <input type="button" name="buyBtn" value="구매하기" style="padding:30px">
      </form>
   </div>   

</div>


<div class="buyList hide">
   <h1>구매목록 페이지 </h1>
   <div>
      <form method="post" id="buyList-form">
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
      <input type="submit" id="purchaseBtn"  value="결제하기" style="padding:30px" formaction="${servlet}purchase&command=insertPurchaseDB">
      </form>
   </div>   
</div>

<script type="text/javascript">
	$(function(){ 
		//전체선택 체크박스 클릭 
		$("#allCheck").click(function(){ 
			
			if($("#allCheck").prop("checked")) { //만약 전체 선택 체크박스가 체크된상태일경우
				//해당화면에 전체 checkbox들을 체크해준다 
				$("input[type=checkbox]").prop("checked",true); 
			}else{ // 전체선택 체크박스가 해제된 경우  
				//해당화면에 모든 checkbox들의 체크를해제시킨다. 
				$("input[type=checkbox]").prop("checked",false); 
			} 
		}) 
	})
</script>


<jsp:include page="../view/footer.jsp"/>
</body>

</html>