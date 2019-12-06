<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>상품 문의하기</title>
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
</style>

</script>
</head>
<body>
<form>
                <div class="full-bg">
   <div class="table">
      <div class="table-cell">
      <form method='post' action="${servlet}qna&command=update">     
                    <div class="login-container">
                        <h3 class="review--title">PRODUCT MANAGEMENT</h3><br><br>
	
                        <label class=form-input--title>Product No : </label></p>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:70px; height:20px;"></input>
                         <label class=form-input--title>Product Name : </label></p>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:150px; height:20px;"></input>
                         <label class=form-input--title>User Price : </label><p>
                         <input type = "text" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:150px; height:20px;"></input>
                        <label class=form-input--title>Product Stock : </label></p>
                         <input type = "select" id="reviewTitle" name='reviewTitle' class="form-input" style="text-align:left; width:70px; height:20px;"></input>
						
                        
                        <input type="submit" name = "update" value="UPDATE"  class="form-btn">

                        
                    </div>
             </form>
     
   </div>
</div>
            </div>

    </div>
    </form>
</body>
</html>