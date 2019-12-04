<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<meta name="viewport" content="width=device-width,initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900|Noto+Sans+KR:100,300,400,500,700,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville:700&display=swap" rel="stylesheet">
		
</head>
<body>
<!--헤더-->     
        
        <header class="header">  
            <div class="header__nav__mid layout--center">
                <a href="<%=application.getContextPath()%>/view/index.html" class="header__logo">NEVER MINE MALL</a>
                <ul class="header__nav__mid_bottom clearfix">
                    <li><a href="<%=application.getContextPath()%>/servlet?command=searchJacket" class="header__nav__mid-title">JACKET</a></li>
                    <li><a href="<%=application.getContextPath()%>/servlet?command=searchCoat" class="header__nav__mid-title">COAT</a></li>              
                    <li><a href="<%=application.getContextPath()%>/servlet?command=searchPadding" class="header__nav__mid-title">PADDING</a></li>              
                </ul>
            </div>
            
            <ul class="header__nav__right clearfix">
            <% 
            	String userId = (String)session.getAttribute("userId");
            	
            	if(userId ==null){
            		%><li><a href="<%=application.getContextPath()%>/user/login.jsp" id="login" class="header__nav__title">LOGIN</a></li>
            		<li><a href="<%=application.getContextPath()%>/user/login.jsp" id="loginMy" class="header__nav__title">MYPAGE</a></li> 
            		<li><a href="<%=application.getContextPath()%>/user/login.jsp" class="header__nav__title">CART</a></li><%  
            	}else{
            		%><li><a href="<%=application.getContextPath()%>/servlet?controller=user&command=logOut&userId=<%=userId%>" id="logOut" class="header__nav__title"> <%=userId%> : LOGOUT</a></li> 
            		<li><a href="<%=application.getContextPath()%>/myPage/myPage.jsp" id="logOutmy" class="header__nav__title">MYPAGE</a></li>  
            		<li><a href="<%=application.getContextPath()%>/servlet?controller=cart&command=selectAll" class="header__nav__title">CART</a></li> <%  
            	}
            
            %>
                <li><a href="<%=application.getContextPath()%>/user/signUp.jsp" class="header__nav__title">SIGNUP</a></li>
            </ul>    
            
        </header>

</body>
</html>