<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/style.css">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link
   href="https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900|Noto+Sans+KR:100,300,400,500,700,900"
   rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
   rel="stylesheet">
<link
   href="https://fonts.googleapis.com/css?family=Libre+Baskerville:700&display=swap"
   rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
.menubar{
border:none;
border:0px;
margin:0px;
padding:0px;
font: 67.5% "Lucida Sans Unicode", "Bitstream Vera Sans", "Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica, sans-serif;
font-size:14px;
font-weight:bold;
}

.menubar ul{
height:50px;
list-style:none;
margin:0;
padding:0;
}

.menubar li{
float:left;
padding:0px;
}

.menubar li a{
background: rgba(255, 255, 255, 1);
color: #000000;
display:block;
font-weight:normal;
line-height:50px;
margin:0px;
padding:0px 25px;
text-align:center;
text-decoration:none;
}

.menubar li a:hover, .menubar ul li:hover a{
background: rgba(255, 255, 255, 1);
color: #000000;
text-decoration:none;
}

.menubar li ul{
background: rgba(255, 255, 255, 1);
display:none; /* 평상시에는 드랍메뉴가 안보이게 하기 */
height:auto;
padding:0px;
margin:0px;
border:0px;
position:absolute;
width:200px;
z-index:200;
/*top:1em;
/*left:0;*/
}

.menubar li:hover ul{
display:block; /* 마우스 커서 올리면 드랍메뉴 보이게 하기 */
}

.menubar li li {
background: rgb(255, 255, 255);
display:block;
float:none;
margin:0px;
padding:0px;
width:200px;
}

.menubar li:hover li a{
background:none;
}

.menubar li ul a{
display:block;
height:50px;
font-size:12px;
font-style:normal;
margin:0px;
padding:0px 10px 0px 15px;
text-align:left;
}

.menubar li ul a:hover, .menubar li ul li:hover a{
background: rgb(220, 220, 220);
border:0px;
color:#000000;
text-decoration:none;
}

.menubar p{
clear:left;
}
</style>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>

   <!--헤더-->

   <header class="header">
      <div class="header__nav__mid layout--center">
         <a href="<%=application.getContextPath()%>/view/index.html"
            class="header__logo">NEVER MINE MALL</a>
         <ul class="header__nav__mid_bottom clearfix">
            <li><a
               href="<%=application.getContextPath()%>/servlet?command=searchByCategory&category=자켓&pageNo=1"
               class="header__nav__mid-title">JACKET</a></li>
            <li><a
               href="<%=application.getContextPath()%>/servlet?command=searchByCategory&category=코트&pageNo=1"
               class="header__nav__mid-title">COAT</a></li>
            <li><a
               href="<%=application.getContextPath()%>/servlet?command=searchByCategory&category=패딩&pageNo=1"
               class="header__nav__mid-title">PADDING</a></li>
         </ul>
      </div>
      <div class="menubar">
         <ul class="header__nav__right clearfix">
            <%
            String userId = (String) session.getAttribute("userId");
            if (userId == null) {
            %>
             <li><a href="<%=application.getContextPath()%>/user/login.jsp" id="login" class="header__nav__title">LOGIN</a></li>
             <li><a href="<%=application.getContextPath()%>/user/login.jsp" id="loginMy" class="header__nav__title">MYPAGE</a></li>
            <li><a href="<%=application.getContextPath()%>/user/login.jsp"class="header__nav__title">CART</a></li>
            <%
            } else {
            %>
            <li><a href="<%=application.getContextPath()%>/servlet?controller=user&command=logOut&userId=<%=userId%>" id="logOut" class="header__nav__title"> <%=userId%> : LOGOUT</a></li>
             
             <li><a id="logOutmy" class="header__nav__title">MYPAGE</a>
               <ul>
                    <li><a href="<%=application.getContextPath()%>/myPage/myPage.jsp">회원정보 수정</a></li>
                    <li><a href="${pageContext.request.contextPath}/servlet?controller=purchase&command=selectHistory">구매내역</a></li>
                    <li><a href="<%=application.getContextPath()%>/myPage/qna.jsp">QnA</a></li>
                </ul>
             </li>
             <li><a href="<%=application.getContextPath()%>/servlet?controller=cart&command=selectAll" class="header__nav__title">CART</a></li>
             <%
            }
            %>
             <li><a href="<%=application.getContextPath()%>/user/signUp.jsp" class="header__nav__title">SIGNUP</a></li>
         </ul>
      </div>

   </header>

   <!-- 검색창 -->
   <div class="container">
      <div class="row">
         <div class="col-md-6 col-md-offset-3"></div>
      </div>
      <div class="row">
         <div class="col-md-4 col-md-offset-3">
            <form action="${servlet}product&command=searchByKeyword&pageNo=1" method='post'
               class="search-form">
               <div class="form-group has-feedback">
                  <label for="search" class="sr-only">Search</label> <input
                     type="text" class="form-control" name="keyword" id="search"
                     placeholder="상품명 또는 카테고리 입력"> <span
                     class="glyphicon glyphicon-search form-control-feedback"></span>
               </div>
            </form>
         </div>
      </div>
   </div>

</body>
</html>