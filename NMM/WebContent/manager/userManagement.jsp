<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<!-- <script> 
      setTimeout(function(){
         location.reload();
      }, 10000);
</script> -->
</head>
<style>
body,html{
    height: 100%;
    background-color: #f4f4f4;
    font-family: 'Maven Pro','Noto Sans KR';
}
th{
    text-align: center;
}
.table{
    height: auto;
    display:table;
    margin: 0 auto;
    text-align: center;
}
.table--title{
    width: 100%;
    text-align: center;
    font-size: 50px;
}
</style>

<script type="text/javascript">
	function selectAll(){
		
	    $.ajax({
		  type:"get",	//select는 보통 get를 많이쓴다
		  url:"../selectServlet",
	    dataType: "json",//서버에게 받은 응답결과 type(text, xml, html, json)
	  //   data : $("#inForm").serialize() ,//서버에게 전송할 parameter
	    success: function(result){//select에서 나온 list를 json으로 받아서 여기서 확인
			// alert(result);
			var str="";
				$.each(result,function(index,item){
					 alert(index+"/"+item.name);
					 /*
					str+="<tr>";
					str+="<td>"+(index+1)+"</td>";
					str+="<td><a href='#'>"+item.id+"</a></td>";
					str+="<td>"+item.name+"</td>";
					str+="<td>"+item.age+"</td>";
					str+="<td>"+item.tel+"</td>";
					str+="<td>"+item.addr+"</td>";
					str+="<td><input type='button' value='삭제' name='"+item.id+"'delete'></td>";
					str+="</tr>";
					*/
				});
	    } ,
	    error : function(err){
	  	  console.log(err+"=> 오류발생");
	    }
		});//ajax끝
		
		  selectAll();
		  setInterval(selectAll, 5000);//5초마다 갱신
	}
</script>
<body>
   
   <div name="userManagement">
<h1 class="table--title">회원 관리 </h1>
<form method='post' action="<%=application.getContextPath()%>/manager/userManagementUpdate.jsp">
<table class="table">
      <tr>
         <th>회원 번호</th>
         <th>회원 ID</th>
         <th>회원 이름</th>
         <th>회원 비밀번호</th>
         <th>기능</th>

      </tr>
      
      
      
      <tr>
            <td>userNo</td>
            <td><a href="#" class=openMask>userID</a></td>
            <td>userName </td>
            <td>userPassword</td>
            <td><input type="submit" value="수정하기"><input type="button" value= "삭제하기"></td>
            </tr>
   </table>
    </form>
   </div>
   
</body>
</html>