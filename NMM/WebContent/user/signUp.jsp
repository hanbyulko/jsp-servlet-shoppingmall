<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900|Noto+Sans+KR:100,300,400,500,700,900" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>NMM SignUp</title>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<style>
/* CSS RESET */
* {
    padding: 0;
    border: 0;
    margin: 0;
}
a {text-decoration: none;}
li {list-style: none;}

body,html{
    height: 100%;
    background-color: #f4f4f4;
    font-family: 'Maven Pro','Noto Sans KR';
}

.full-bg{
    height: 100%;
}

.table{
    height: 100%;
    display:table;
    margin: 0 auto;
}
.table-cell{
    height: 100%;
    display: table-cell;
    vertical-align: middle;

}
.login-container{
    width: 500px;
    background-color: #fff;
    padding: 70px 20px;
    box-sizing: border-box;

}
.login--title{
    width: 100%;
    text-align: center;
    font-size: 50px;
}
.form-input{
    width: 100%;
    padding: 10px 20px;
    font-size: 16px;
    outline: none;
    margin: 5px 0;
    border: 1px solid #efefef;
    box-sizing: border-box;
}

.form-input:focus{
    box-shadow: 3px 3px 5px rgba(0,0,0,0.1);
    border: none;
}

.form-input--title{
    width: 100%;
    display: block;
    margin-top: 5px;
    margin-bottom: 0;
    box-sizing: border-box;
    font-size: 16px;
}
.form-btn{
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

.form-btn:hover{
    background-color: brown;
    box-shadow: 3px 3px 3px rgba(0,0,0,0.5);
    
}

</style>


<script type="text/javascript">
document.getElementById('userBirth').value = new Date().toISOString().substring(0, 10);
</script>

<script type="text/javascript">
function goPopup(){
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
function jusoCallBack(roadFullAddr,addrDetail, jibunAddr){
		document.form.userAddr.value = roadFullAddr;
}

function cheakFunction() {
	if($("#userId").val() == ""){
	    alert("아이디 입력바람");
	    $("#userId").focus();
	    return false;
	  }
	if($("#userPwd").val() == ""){
	    alert("비밀번호 입력바람");
	    $("#userPwd").focus();
	    return false;
	  }
	if($("#userName").val() == ""){
	    alert("이름 입력바람");
	    $("#userName").focus();
	    return false;
	  }
	if($("#userAddr").val() == ""){
	    alert("주소 입력바람");
	    $("#userAddr").focus();
	    return false;
	  }
	if($("#userPhone").val() == ""){
	    alert("핸드폰 입력바람");
	    $("#userPhone").focus();
	    return false;
	  }
	if($("#userEmail").val() == ""){
	    alert("이메일 입력바람");
	    $("#userEmail").focus();
	    return false;
	  }
	
}

  $(document).ready(function(){
	  
	  $("#userId").keyup(function(){
		  if($(this).val()==""){
			  $("span").text("ID 입력해주세요. ");
			  return;
		  }
		  
		  $.ajax({
			  type:"post",
			  url:"../idSelect",
		      dataType: "text",//서버에게 받은 응답결과 type(text, xml, html, json)
		      data : {id: $(this).val() } ,//서버에게 전송할 parameter
		      success: function(result){
		    	  $("span").html(result);
		      } ,
		      error : function(err){
		    	  console.log(err+"=> 오류발생");
		      }
		  });//ajax끝
	  });//keyup끝
  });
		  
</script>
<body>

<div class="full-bg">
	<div class="table">
		<div class="table-cell">
  				<form method="post" onsubmit="return cheakFunction();" action="../servlet?controller=user&command=signUp" name="form" id="form">
                    <div class="login-container">
                        <h3 class="login--title">SIGN UP</h3>
                        
                        <label class=form-input--title><span>    ID 입력해주세요.      </span></label>
                        <input type="text" id ="userId" name="userId" class="form-input" value="">
                        
                        <label class=form-input--title>PASSWORD</label>
                        <input type="password" id="userPwd" name="userPwd" class="form-input" value="">
                        
                        <label class=form-input--title>NAME</label>
                        <input type="text" id ="userName" name="userName" class="form-input" value="">
                        
                        <label class=form-input--title>ADDRESS</label>
                        <input type="text" id ="userAddr" name="userAddr" class="form-input" value="" onClick="goPopup();">
                        
                        <label class=form-input--title>TEL</label>
                        <input type="text" id ="userPhone" name="userPhone" class="form-input" value="" onKeyup="this.value=this.value.replace(/[^0-9]/g,'')">
                        
                        <label class=form-input--title>EMAIL</label>
                        <input type="text" id ="userEmail" name="userEmail" class="form-input" value="">
                        
                        <label class=form-input--title>BIRHT DAY</label>
                        <input type="date" id ="userBirth" name="userBirth" class="form-input" value="">
                        
                        <input type="submit" class="form-btn" value="SIGN UP" id="SIGNUP">
                        <input type="button" class="form-btn" value="MAIN" id="main" onclick="location.href='../servlet?controller=product+review&command=productList'">
                    </div>
 				</form>
		</div>
	</div>
</div>
</body>
</html>