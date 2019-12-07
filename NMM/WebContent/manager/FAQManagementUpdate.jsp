<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js"></script>
<script>
	function info_chk() {
		return true;
	}
	function info_chk2(frm) {
		frm.action = "${servlet}review&command=update";
		frm.submit();
		return true;
	}
	
</script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"> 
//<![CDATA[
    function wrapWindowByMask(){
 
        var maskHeight = $(document).height();  
        var maskWidth = $(window).width();  
 
        $("#mask").css({"width":maskWidth,"height":maskHeight});  
 
 
        $("#mask").fadeIn(0);      
        $("#mask").fadeTo("slow",0.6);    
 
        $(".window").show();
 
    }
 
    $(document).ready(function(){
        $(".openMask").click(function(e){
            e.preventDefault();
            wrapWindowByMask();
        });
 
        $(".window .close").click(function (e) {  
            e.preventDefault();  
            $("#mask, .window").hide();  
        });       
 
        $("#mask").click(function () {  
            $(this).hide();  
            $(".window").hide();  
 
        });      
 
    });
 
//]]>
</script>

<style>
/* CSS RESET */
* {
	padding: 0;
	border: 0;
	margin: 0;
}

a {
	text-decoration: none;
}

li {
	list-style: none;
}

body, html {
	height: 100%;
	background-color: #f4f4f4;
	font-family: 'Maven Pro', 'Noto Sans KR';
}

.full-bg {
	height: 100%;
}

.table {
	height: 100%;
	display: table;
	margin: 0 auto;
}

.table-cell {
	height: 100%;
	display: table-cell;
	vertical-align: middle;
}

.login-container {
	width: 500px;
	background-color: #fff;
	padding: 70px 20px;
	box-sizing: border-box;
}

.review--title {
	width: 100%;
	text-align: center;
	font-size: 50px;
}

.form-input {
	width: 100%;
	padding: 10px 20px;
	font-size: 16px;
	outline: none;
	margin: 5px 0;
	border: 1px solid #efefef;
	box-sizing: border-box;
}

.form-input:focus {
	box-shadow: 3px 3px 5px rgba(0, 0, 0, 0.1);
	border: none;
}

.form-input--title {
	width: 100%;
	display: block;
	margin-top: 5px;
	margin-bottom: 0;
	box-sizing: border-box;
	font-size: 16px;
}

.form-btn {
	display: block;
	width: 100%;
	font-size: 16px;
	height: 40px;
	background-color: #000;
	color: #fff;
	box-sizing: border-box;
	margin: 5px 0;
	cursor: pointer;
}

.form-btn:hover {
	background-color: brown;
	box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.5);
}

div.stars {
	width: 270px;
	display: table-row;
}

input.star {
	display: none;
}

label.star {
	float: right;
	padding: 10px;
	font-size: 36px;
	color: #444;
	transition: all .2s;
}

input.star:checked ~ label.star:before {
	content: '\2605';
	color: #FD4;
	transition: all .25s;
}

label.star:hover {
	transform: rotate(-15deg) scale(1.3);
}

label.star:before {
	content: '\2605';
}
</style>


</head>


<body>
	<div class="full-bg">
		<div class="table">
			<div class="table-cell">
				<div class="login-container">
					<form method='post' action="${servlet}review&command=update">
						<h3 class="review--title">문의 답변 등록</h3>
						<br> <br> <label class=form-input--title>문의 제목 </label>
						<p>
						<input type="text" hidden='hidden' value='${qnaDTO.qnaNo}'
								style="text-align: left; width: 460px; height: 30px;" readonly>
							<input type="text" id="reviewTitle" name='reviewTitle'
								class="form-input" value='${qnaDTO.qnaTitle}'
								style="text-align: left; width: 460px; height: 30px;" readonly>
						<p>

							<label class=form-input--title>문의 내용 </label>
						<p>	
							<input type="text" id="reviewContent" name="reviewContent"
								class="form-input" value='${qnaDTO.qnaContent}'
								style="text-align: left; width: 460px; height: 180px;" readonly>
							<label class=form-input--title>답변 내용 </label>
						<p>
							<input type="text" id="review" name="reviewContent"
								class="form-input"
								style="text-align: left; width: 460px; height: 200px;">
							<input type="submit" name="insert" value="답변 등록" class="form-btn" >
							<input type="reset" name="cancel" value="취소" class="form-btn" >
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>