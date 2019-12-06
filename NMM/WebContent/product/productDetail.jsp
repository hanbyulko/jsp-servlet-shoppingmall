<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{width:500px; height:700px;}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#minus").click(function(){
		value = parseInt($("#quantity").val())-1;
		if(value<=1){
			$("#quantity").val(1);
			value=1;
		}else{
			$("#quantity").val(value);
		}
		var total = eval(value*$("#price").text());
		$("#total").text(total+" WON"); 
	});
	
	$("#plus").click(function(){
		var value = parseInt($("#quantity").val())+1;
		$("#quantity").val(value);
		var total = eval(value*$("#price").text());
		$("#total").text(total+" WON"); 
	});
	
	$("#cart").click(function(){
		
		location.href="${pageContext.request.contextPath}/servlet?controller=cart&command=insert&productNo="+eval(${product.productNo})+"&cartQty="+eval($("#quantity").val());
		
	});
	
	$("#buy").click(function(){
		
		location.href="${pageContext.request.contextPath}/servlet?controller=purchase&command=insert&productNo="+eval(${product.productNo})+"&cartQty="+eval($("#quantity").val());
	});	
});
/* function plus(){
	var value = document.getElementById("quantity").value+1;
	
	
}
function minus(){
	var value = document.getElementById("quantity").value = eval(document.getElementById("quantity").value-1);
	if(document.getElementById("quantity").value==0){
		document.getElementById("quantity").value=0;
	}
} */
</script>
</head>
<body>
<jsp:include page="../view/top.jsp"/>

<%-- <table>
<tr><td rowspan="50"><img alt="이미지입니다." src="${imgPath}${product.productName}_L_1.jpg"></td><td>상품이름 : </td><td>${product.productName} </td><tr>
<tr><td>PRICE : </td><td id="price">${product.productPrice}</td><tr>
<tr><td>COLOR : </td><td>${product.productColor}</td><tr>
<tr><td>SIZE : </td><td>${product.productSize}</td><tr>
<tr><td>QUANTITY : </td><td><BUTTON TYPE="BUTTON" id="minus">-</BUTTON><input type="text" value=1 size="2" id="quantity"></input><BUTTON TYPE="BUTTON" id="plus">+</BUTTON></td><tr>
<tr><td>TOTAL : </td><td id ="total">${product.productPrice} WON</td><tr>
<tr><td colspan="2"><button type="button" value="">구매하기</button></td><tr>
<tr><td colspan="2"><button type="button" value="">장바구니</button></td><tr>
</table>
<img alt="이미지입니다." src="${imgPath}${product.productName}_D_1.jpg">
<img alt="이미지입니다." src="${imgPath}${product.productName}_D_2.jpg">

 --%>


<!--탑 인포메이션-->
        <div class="top-container">



<!--대표사진-->
            <div class="top-img clearfix">
                <img src="${imgPath}${product.productName}_L_1.jpg">
            </div>
<!--탑 구매창인포-->         
            <div class="detail-top-info-container clearfix">
                <div class="top-info-title-wrap clearfix">
                    <div class="info__icon__new">NEW</div>
                    <div class="top-info-title">${product.productName}</div>
                    <div class="top-info-price" id="price">${product.productPrice}</div>
                </div>
                
                <div class="top-info-select clearfix">
                    
                    <div class="top-info-color clearfix">
                        <p class="top-info-select-title">COLOR</p>
                        ${product.productColor}
                    </div>
                    
                
                
                    <div class="top-info-size clearfix">
                        <p class="top-info-select-title">SIZE</p>
                        <div class="select-form-container">
                            <select class="select-form">
                                <option>[필수] 사이즈 선택</option>
                                <option> ${product.productSize}</option>
                            </select>
                            
                            <span class="select-icon">
                                <i class="material-icons">expand_more</i>
                            </span>
                        </div>
                    </div>
                    
                    <div class="top-info-quantity clearfix">
                        <p class="top-info-select-title">QUANTITY</p>
                        
                        <div class="spiner-form-container clearfix">
                        <button class="spiner-minus"><i class="material-icons" id="minus">remove</i></button>
                        <input type="text" class="spiner-text" id="quantity" value="1">
                        <button class="spiner-plus"><i class="material-icons" id="plus">add</i></button>
                        </div>
                    </div> 
                
                    <div class="total_wrap clearfix">
                        <p class="top-info-select-title">TOTAL</p>
                        <p class="total_price" id="total">${product.productPrice} WON</p>
                    </div>
                    
                
                    <div class="form-field">
                        <button class="form-btn cart" id="cart">ADD TO CART</button>
                        <button class="form-btn wish" id="buy">BUY NOW</button>
                    </div>
                </div>
            </div>
        </div> 




















<%-- <% if(request.getAttribute("list")!=null){
	out.println("<jsp:include page='../review/reviewDetail.jsp' />");
}
%> --%>
<jsp:include page='../review/reviewDetail.jsp' />
<jsp:include page="../view/footer.jsp"/>
</body>
</html>