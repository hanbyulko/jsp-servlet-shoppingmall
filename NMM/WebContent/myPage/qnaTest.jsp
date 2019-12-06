<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>상품 문의하기</title>
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
<form>
    <div id ="wrap"> 
            <div id="mask"></div>
            <div class="window">
                <div class="full-bg">
   					<div class="table">
      					<div class="table-cell">
      <form method='post' action="${servlet}qna&command=insert">     
                    <div class="login-container">
                        <h3 class="review--title">How Can I Help You?</h3><br><br>
                     </div>
                        <label class=form-input--title>Product Name : </label></p>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:200px; height:20px;"></input>
                  <label class=form-input--title>Title : </label><p>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:200px; height:20px;"></input>
                        <label class=form-input--title>Content : </label><p>
                        <input type="text" id="reviewContent" name="reviewContent" class="form-input" style="text-align:left; width:400px; height:200px;"></input>
                        
                        <input type="submit" name = "insert" value="Submit"  class="form-btn">

                    </div>
             </form>
   						</div>
							</div>
            					</div>
            <table border="0" cellpadding="0" cellspacing="0" width="100%">       
                <tr>
                    <td align="left">
                    <a href="<%=application.getContextPath()%>/myPage/qna.jsp" class="openMask" style="vertical-align: middle">REVIEW</a>
                    </td>
                </tr>       
            </table>
        </div>
    </div>
    </form>
</body>
</html>