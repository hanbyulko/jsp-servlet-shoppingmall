<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NMM Admin Login</title>
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
    background-color: #444444;
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
    font-size: 32px;
}
.form-input{
    width: 100%;
    padding: 10px 20px;
    font-size: 20px;
    outline: none;
    margin: 10px 0;
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
    margin: 5px 0;
    box-sizing: border-box;
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
function cheakFunction() {
	
	if($("#mgtUserId").val()==""){
	    alert("아이디 입력바람");
	    $("#mgtUserId").focus();
	    return false;
	  }
	if($("#mgtUserPwd").val()==""){
	    alert("비밀번호 입력바람");
	    $("#mgtUserPwd").focus();
	    return false;
	  }
}
</script>
</head>
<body>

<div class="full-bg">
	<div class="table">
		<div class="table-cell">
  				<form method="post" onsubmit="return cheakFunction();" action="<%=application.getContextPath()%>/servlet?controller=managerUser&command=login">
                    <div class="login-container">
                        <h3 class="login--title">ADMIN LOGIN</h3>
                        
                        <label class=form-input--title>ADMIN ID</label>
                        
                        <input type="text" id ="mgtUserId" name="mgtUserId" class="form-input" value="">
                        
                        <label class=form-input--title>ADMIN PASSWORD</label>
                        
                        <input type="password" id="mgtUserPwd" name="mgtUserPwd" class="form-input">
                        
                        
                        <input type="submit" class="form-btn" value="LOG IN">
                    </div>
 				</form>
		</div>
	</div>
</div>

</body>


</html>