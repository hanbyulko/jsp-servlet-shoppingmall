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
} function info_chk2(frm) { 
   frm.action="${servlet}review&command=update"; 
   frm.submit();
   return true; 
   } </script>

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


</head>


<body>
<form method='post' action="${servlet}review&command=insert" onsubmit='return info_chk()'>
<div class="full-bg">
   <div class="table">
      <div class="table-cell">
              <form method="post" action="../servlet?controller=user&command=signUp">
                    <div class="login-container">
                        <h3 class="login--title">만족도 평가</h3>
                        <h6 class="login--title">상품에 만족하셨나요 ?</h6>
                        
                        <label class=form-input--title>별점을 선택해주세요.</label>
                        <input type="radio" id ="userId" name="reviewStar" class="form-input" value = 1><strong>*</strong>
                         <input type="radio" id ="userId" name="reviewStar" class="form-input" value = 2><strong>**</strong>
                          <input type="radio" id ="userId" name="reviewStar" class="form-input" value = 3><strong>***</strong>
                           <input type="radio" id ="userId" name="reviewStar" class="form-input" value = 4><strong>****</strong>
                            <input type="radio" id ="userId" name="reviewStar" class="form-input" value = 5><strong>*****</strong>
                        
                        
                        <h3 class="login--title">상품리뷰작성</h3>
                        
                        <label class=form-input--title>리뷰제목 : </label><p>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:200px; height:20px;"><p>

                        <label class=form-input--title>리뷰 내용 : </label><p>
                        <input type="text" id="reviewContent" name="reviewContent" class="form-input" style="text-align:left; width:400px; height:400px;">
                        
                        
                        <input type="submit" name = "insert" value="등록"  class="form-btn" >
                  <input type="button" name = "update" value="수정" class="form-btn" onclick='return info_chk2(this.form)'>

                        
                    </div>
             </form>
      </div>
   </div>
</div>
</body>





</html>