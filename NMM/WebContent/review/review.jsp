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
.review--title{
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
div.stars {
  width: 270px;
  display: table-row;
}

input.star { display: none; }

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




label.star:hover { transform: rotate(-15deg) scale(1.3); }

label.star:before {
  content: '\2605';
}
</style>


</head>


<body>

<div class="full-bg">
   <div class="table">
      <div class="table-cell">
      <form method='post' action="${servlet}review&command=insert">     
                    <div class="login-container">
                        <h3 class="review--title">Survey</h3><br><br>
                        
                         <label class=form-input--title>상품에 만족하셨나요?</label>
   <div class="stars">
   <input class="star star-1" id="star-1" name="reviewStar" value = 5 type="radio"/>
    <label class="star star-1" for="star-1"></label>
  <input class="star star-2" id="star-2" name="reviewStar" value = 4 type="radio"/>
    <label class="star star-2" for="star-2"></label>
    <input class="star star-3" id="star-3" name="reviewStar" value =3 type="radio"/>
    <label class="star star-3" for="star-3"></label>
    <input class="star star-4" id="star-4" name="reviewStar" value = 2 type="radio"/>
    <label class="star star-4" for="star-4"></label>
    <input class="star star-5" id="star-5" name="reviewStar" value = 1 type="radio"/>
    <label class="star star-5" for="star-5"></label>

    
    <br><br><br>

 
  
</div>
                   
                        <h3 class="review--title">Product Review</h3><br><br>
                        
                        <label class=form-input--title>리뷰제목 : </label><p>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:200px; height:20px;"><p>

                        <label class=form-input--title>리뷰 내용 : </label><p>
                        <input type="text" id="reviewContent" name="reviewContent" class="form-input" style="text-align:left; width:400px; height:400px;">
                        
                        
                        <input type="submit" name = "insert" value="등록"  class="form-btn" >

                        
                    </div>
             </form>
      </div>
   </div>
</div>
</body>





</html>