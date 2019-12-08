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
   var str;
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
      
      <% 
      if(session.getAttribute("userId")==null){
         %>
         location.href="${pageContext.request.contextPath}/user/login.jsp";
         <%
      }else{
         %>
         location.href="${pageContext.request.contextPath}/servlet?controller=cart&command=insert&productNo="+eval(str[0])+"&cartQty="+eval($("#quantity").val());
         <%
      }
      %>
            
            
   });
   
   $("#buy").click(function(){
      <% 
      if(session.getAttribute("userId")==null){
         %>
         location.href="${pageContext.request.contextPath}/user/login.jsp";
         <%
      }else{
         %>
         location.href="${pageContext.request.contextPath}/servlet?controller=purchase&command=insertPurchaseDBForDetail&productNo="+eval(str[0])+"&cartQty="+eval($("#quantity").val());
         <%
      }
      %>
      
   });   
   
   $('select').on('change', function (e) {
       var optionSelected = $("option:selected", this);
       var valueSelected = this.value;
       str = valueSelected.split("/");
   });
	var str;
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
		
		<% 
		if(session.getAttribute("userId")==null){
			%>
			location.href="${pageContext.request.contextPath}/user/login.jsp";
			<%
		}else{
			%>
			location.href="${pageContext.request.contextPath}/servlet?controller=cart&command=insert&productNo="+eval(str[0])+"&cartQty="+eval($("#quantity").val());
			<%
		}
		%>
				
				
	});
	
	$("#buy").click(function(){
		<% 
		if(session.getAttribute("userId")==null){
			%>
			location.href="${pageContext.request.contextPath}/user/login.jsp";
			<%
		}else{
			%>
			location.href="${pageContext.request.contextPath}/servlet?controller=purchase&command=insertPurchaseDBForDetail&productNo="+eval(str[0])+"&cartQty="+eval($("#quantity").val());

			<%
		}
		%>
		
	});	
	
	$('select').on('change', function (e) {
	    var optionSelected = $("option:selected", this);
	    var valueSelected = this.value;
	    str = valueSelected.split("/");
	});
}); 

</script>
</head>
<body>
<jsp:include page="../view/top.jsp"/>


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
                        <p class="top-info-select-title"></p>
                    </div>
                    
                
                
                    <div class="top-info-size clearfix">
                        <p class="top-info-select-title">SIZE AND COLOL</p>
                        <div class="select-form-container">
                            <select class="select-form" id="selectedNo">
                                <option>사이즈 선택 및 COLOR</option>
                                <c:forEach items="${listName}" var="listName">
                                <option > ${listName.productNo}/${listName.productSize}/${listName.productColor}/${listName.productStock}</option>
                                </c:forEach>
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
<jsp:include page='../review/reviewDetail.jsp' />
<jsp:include page="../view/footer.jsp" />
</body>
</html>