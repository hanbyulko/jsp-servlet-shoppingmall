<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
 
</script>
<style> 
#mask {  
    position:absolute;  
    z-index:9000;  
    background-color:#000;  
    display:none;  
    left:0;
    top:0;
} 
.window{
    display: none;
    position:absolute;  
    left:50%;
    top:50px;
    margin-left: -500px;
    width:1000px;
    height:500px;
    background-color:#FFF;
    z-index:10000;   
 }
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

.qna--title{
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
    width: 100px;
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
</head>
<body>
    <div class="review">
 <form method='post' action="${servlet}review&command=update"> 
    <div id ="wrap"> 
            <div id="mask"></div>
            <div class="window">
                <div class="full-bg">
   <div class="table">
      <div class="table-cell">
         
                    <div class="login-container">
                    <h3 class="review--title">REVIEW UPDATE</h3><br>
                        
                         <label class=form-input--title>STARS: </label>
  <div class="table">
   <c:choose>
   <c:when test="${list.reviewStar}==1}">
   <input class="star star-1" id="star-1" name="reviewStar" value = 1 type="radio" />
    <label class="star star-1" for="star-1"></label>
  <input class="star star-2" id="star-2" name="reviewStar" value = 2 type="radio"/>
    <label class="star star-2" for="star-2"></label>
    <input class="star star-3" id="star-3" name="reviewStar" value =3 type="radio"/>
    <label class="star star-3" for="star-3"></label>
    <input class="star star-4" id="star-4" name="reviewStar" value = 4 type="radio"/>
    <label class="star star-4" for="star-4"></label>
    <input class="star star-5" id="star-5" name="reviewStar" value = 5 type="radio" checked="checked"/>
    <label class="star star-5" for="star-5"></label>
   </c:when>
   <c:when test="${list.reviewStar}==2}">
   <input class="star star-1" id="star-1" name="reviewStar" value = 1 type="radio"/>
    <label class="star star-1" for="star-1"></label>
  <input class="star star-2" id="star-2" name="reviewStar" value = 2 type="radio" />
    <label class="star star-2" for="star-2"></label>
    <input class="star star-3" id="star-3" name="reviewStar" value =3 type="radio"/>
    <label class="star star-3" for="star-3"></label>
    <input class="star star-4" id="star-4" name="reviewStar" value = 4 type="radio" checked="checked"/>
    <label class="star star-4" for="star-4"></label>
    <input class="star star-5" id="star-5" name="reviewStar" value = 5 type="radio"/>
    <label class="star star-5" for="star-5"></label>
   </c:when>
   <c:when test="${list.reviewStar}==3}">
   <input class="star star-1" id="star-1" name="reviewStar" value = 1 type="radio"/>
    <label class="star star-1" for="star-1"></label>
  <input class="star star-2" id="star-2" name="reviewStar" value = 2 type="radio"/>
    <label class="star star-2" for="star-2"></label>
    <input class="star star-3" id="star-3" name="reviewStar" value =3 type="radio" checked="checked"/>
    <label class="star star-3" for="star-3"></label>
    <input class="star star-4" id="star-4" name="reviewStar" value = 4 type="radio"/>
    <label class="star star-4" for="star-4"></label>
    <input class="star star-5" id="star-5" name="reviewStar" value = 5 type="radio"/>
    <label class="star star-5" for="star-5"></label>
   </c:when>
   <c:when test="${list.reviewStar}==4}">
<input class="star star-1" id="star-1" name="reviewStar" value = 1 type="radio"/>
    <label class="star star-1" for="star-1"></label>
  <input class="star star-2" id="star-2" name="reviewStar" value = 2 type="radio" checked="checked"/>
    <label class="star star-2" for="star-2"></label>
    <input class="star star-3" id="star-3" name="reviewStar" value =3 type="radio"/>
    <label class="star star-3" for="star-3"></label>
    <input class="star star-4" id="star-4" name="reviewStar" value = 4 type="radio" />
    <label class="star star-4" for="star-4"></label>
    <input class="star star-5" id="star-5" name="reviewStar" value = 5 type="radio"/>
    <label class="star star-5" for="star-5"></label>
   </c:when>
   <c:otherwise>
 <input class="star star-1" id="star-1" name="reviewStar" value = 1 type="radio" checked="checked"/>
    <label class="star star-1" for="star-1"></label>
  <input class="star star-2" id="star-2" name="reviewStar" value = 2 type="radio"/>
    <label class="star star-2" for="star-2"></label>
    <input class="star star-3" id="star-3" name="reviewStar" value =3 type="radio"/>
    <label class="star star-3" for="star-3"></label>
    <input class="star star-4" id="star-4" name="reviewStar" value = 4 type="radio"/>
    <label class="star star-4" for="star-4"></label>
    <input class="star star-5" id="star-5" name="reviewStar" value = 5 type="radio" />
    <label class="star star-5" for="star-5"></label>
   </c:otherwise>
</c:choose>
   
</div>
							</div>
                        <label class=form-input--title>REVIEW TITLE: </label>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:200px; height:20px;"></input>
                        <label class=form-input--title>REVIEW Content : </label><p>
                        <input type="text" id="reviewContent" name="reviewContent" class="form-input" style="text-align:left; width:400px; height:200px;"></input>
                        
                        <input type="submit" name = "insert" value="Submit"  class="form-btn" >

                    </div>
             </form>
   </div>
</div>
            </div>
            <table border="0" cellpadding="0" cellspacing="0" width="100%">       
                <tr>
                    <td align="left">
                    <a href="<%=application.getContextPath()%>/review/reviewUpdate.jsp" class="openMask" style="vertical-align: middle">REVIEW UPDATE</a>
                    </td>
                </tr>       
            </table>
        </div>
    </div>
</body>
</html>
