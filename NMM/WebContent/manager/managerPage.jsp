<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<!--
	Hyperspace by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

	<head>
		<title>Hyperspace by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<style type="text/css">
		img {width: 200px; height: 150px; margin: 0; padding: 0;}
		p{color: "#0d001a";}
		</style>
		<script type="text/javascript">
		
		
		</script>
		
	</head>
	
	<body class="is-preload">

		<!-- Sidebar -->
			<section id="sidebar">
				<div class="inner">
					<nav>
						<ul>
							<li><a href="#intro">Welcome</a></li>
							<li><a href="#one">관리자 매출액</a></li>
							<li><a href="#two">관리자 ㅅ</a></li>
							<li><a href="#three">이동페이지</a></li>
						</ul>
					</nav>
				</div>
			</section>

		<!-- Wrapper -->
			<div id="wrapper">
					<jsp:include page="../view/top.jsp"/>
				<!-- Intro -->
					<section id="intro" class="wrapper style1 fullscreen fade-up">
						<div class="inner">
							<h1>마이페이지 환영한다</h1>
							<p>이 페이지에서 회원정보를 수정하고, 구매내역을 조회할수 있습니다<br />
							<ul class="actions">
								<li><a href="#one" class="button scrolly">구매내역</a></li>
							</ul>
						</div>
					</section>

				<!-- One -->
					<section id="one" class="wrapper style2 spotlights">
						
						<section>
							<a href="#" class="image"><img src="images/OLIVIA.jpg" alt="" data-position="top center" /></a>
							<div class="content">
								<div class="inner">
									<h2>여러분이 구매하신 구매 내역을 확인할수 있습니다</h2>
									<p>여러분에 구매내역을 확인해 보세요!</p>
									<ul class="actions">
										<li><a href="../user/purchase/purchaseHistory.jsp" class="button">구매 내역이동</a></li>
									</ul>
								</div>
							</div>
						</section>
								<section>
										<ul>
										<img alt="11" src="images/1.jpg">
										<img alt="12" src="images/2.jpg">
										<img alt="13" src="images/3.jpg">
										<img alt="14" src="images/4.jpg">
										<img alt="15" src="images/5.jpg">
										<img alt="16" src="images/6.jpg">
										<img alt="17" src="images/7.jpg">
										<img alt="18" src="images/8.jpg">
										<img alt="19" src="images/9.jpg">
										<img alt="20" src="images/10.jpg">
										</ul>
								</section>
					</section>

				<!-- Two -->
					<section id="two" class="wrapper style3 fade-up">
						<div class="inner">
							<h2>내 정보 수정</h2>
							<p>페이지를 이동하여 회원정보를 수정할수 있습니다</p>
							<div class="features">
								<section>
									<span class="icon solid major fa-code"></span>
									<form method="post" action="../servlet?controller=user&command=upDate">
									userId : <%
											if(session.getAttribute("userId")!=null){
												String i = (String)session.getAttribute("userId");
												out.print("<input type='text' id='userId' name='userId' value='"+i+"' readonly><br>");
											}
										%>
									  PWD : <input type="password" id="userPwd" name="userPwd" />
									  userName : <input type="text" id="userName" name="userName" />
									  userPhone : <input type="text" id="userPhone" name="userPhone" onKeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
									  userAddr : <input type="text" id="userAddr" name="userAddr" />
									  userEmail : <input type="text" id="userEmail" name="userEmail" />
									    
									  <input type="submit" value="회원정보 수정" />
									  
									</form>
								</section>
							</div>
						</div>
					</section>

				<!-- Three -->
					<section id="three" class="wrapper style1 fade-up">
						<div class="inner">
							<h2>페이지 이동!</h2>
							<p>페이지 동처리</p>
							<div class="split style1">
								<section>
									<form method="post" action="#">
										<ul class="contact">
										<li><a href="../servlet?controller=product+review&command=productList" class="button">메인페이지 이동</a></li>
									</ul>
									</form>
								</section>
								<section>
									<ul class="contact">
										<li><img alt="1" src="images/1.jpg"></li>
										<li><img alt="2" src="images/2.jpg"></li>
										<li><img alt="3" src="images/3.jpg"></li>
										<li><img alt="4" src="images/4.jpg"></li>
										<li><img alt="5" src="images/5.jpg"></li>
									</ul>
								</section>
							</div>
						</div>
					</section>
					
					<!-- 보이기 페이지 -->	
			<section id="four" class="wrapper style1 fade-up">
						<div class="inner">
							<h2>페이지 이동!</h2>
							<p>페이지 동처리</p>
							<jsp:include page="../view/top.jsp"/>
						</div>
					</section>

			</div>
						<!-- 보이기 페이지 -->	

		<!-- Footer -->
			<footer id="footer" class="wrapper style1-alt">
				<div class="inner">
					<jsp:include page="../view/footer.jsp"/>
				</div>
			</footer>
			

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>